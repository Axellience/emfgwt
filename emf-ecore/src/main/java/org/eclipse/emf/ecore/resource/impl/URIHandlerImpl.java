/**
 * Copyright (c) 2007-2011 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM -
 * Initial API and implementation
 */
package org.eclipse.emf.ecore.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;

/**
 * An implementation of a {@link URIHandler URI handler}.
 */
public class URIHandlerImpl implements URIHandler
{
    /**
     * Creates an instance.
     */
    public URIHandlerImpl()
    {
        super();
    }

    /**
     * This implementation always returns true; clients are generally expected
     * to override this.
     */
    @Override
    public boolean canHandle(URI uri)
    {
        return true;
    }

    /**
     * Returns the value of the {@link URIConverter#OPTION_URI_CONVERTER URI
     * converter option}.
     * @param options the options in which to look for the URI converter.
     * @return the value of the URI converter option.
     */
    protected URIConverter getURIConverter(Map<?, ?> options)
    {
        return (URIConverter) options.get(URIConverter.OPTION_URI_CONVERTER);
    }

    /**
     * Returns the value of the {@link URIConverter#OPTION_RESPONSE response
     * option}.
     * @param options the options in which to look for the response option.
     * @return the value of the response option.
     */
    @SuppressWarnings("unchecked")
    protected Map<Object, Object> getResponse(Map<?, ?> options)
    {
        return (Map<Object, Object>) options.get(URIConverter.OPTION_RESPONSE);
    }

    /**
     * Returns the value of the {@link URIConverter#OPTION_REQUESTED_ATTRIBUTES
     * requested attributes option}.
     * @param options the options in which to look for the requested attributes
     *        option.
     * @return the value of the requested attributes option.
     */
    @SuppressWarnings("unchecked")
    protected Set<String> getRequestedAttributes(Map<?, ?> options)
    {
        return (Set<String>) options.get(URIConverter.OPTION_REQUESTED_ATTRIBUTES);
    }

    /**
     * Returns the value of the {@link URIConverter#OPTION_TIMEOUT timeout
     * option}.
     * @param options the options in which to look for the timeout option.
     * @return the value of the timeout option, or <code>0</code> if not
     *         present.
     * @since 2.9
     */
    protected int getTimeout(Map<?, ?> options)
    {
        Integer timeout = (Integer) options.get(URIConverter.OPTION_TIMEOUT);
        return timeout == null ? 0 : timeout.intValue();
    }

    /**
     * Creates an output stream for the URI, assuming it's a URL, and returns
     * it. Specialized support is provided for HTTP URLs.
     * @return an open output stream.
     * @exception IOException if there is a problem obtaining an open output
     *            stream.
     */
    @Override
    public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException
    {
        return null;
    }

    @Override
    public void store(URI uri, byte[] bytes, Map<?, ?> options, Callback<Map<?, ?>> callback)
    {
        callback.onSuccess(null);
    }

    /**
     * Creates an input stream for the URI, assuming it's a URL, and returns it.
     * @return an open input stream.
     * @exception IOException if there is a problem obtaining an open input
     *            stream.
     */
    @Override
    public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException
    {
        return null;
    }

    @Override
    public void createInputStream(URI uri, Map<?, ?> options, Callback<Map<?, ?>> callback)
    {
        callback.onSuccess(null);
    }

    /**
     * Only HTTP connections support delete.
     */
    @Override
    public void delete(URI uri, Map<?, ?> options) throws IOException
    {
        //
    }

    @Override
    public void delete(URI uri, Map<?, ?> options, Callback<Map<?, ?>> callback)
    {
        callback.onSuccess(null);
    }

    /**
     * This implementation delegates to the {@link #getURIConverter(Map) URI
     * converter}'s {@link URIConverter#getContentHandlers() content handlers}.
     */
    @Override
    public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException
    {
        URIConverter uriConverter = (URIConverter) options.get(URIConverter.OPTION_URI_CONVERTER);
        InputStream inputStream = null;
        Map<String, ?> result = null;
        Map<Object, Object> context = new HashMap<Object, Object>();
        try {
            for (ContentHandler contentHandler : uriConverter.getContentHandlers()) {
                if (contentHandler.canHandle(uri)) {
                    if (inputStream == null) {
                        try {
                            inputStream = createInputStream(uri, options);
                        }
                        catch (IOException exception) {
                            throw exception;
                        }
                        if (!inputStream.markSupported()) {
                            // inputStream = new
                            // BufferedInputStream(inputStream);
                        }
                        inputStream.mark(Integer.MAX_VALUE);
                    } else {
                        inputStream.reset();
                    }
                    Map<String, ?> contentDescription =
                            contentHandler.contentDescription(uri, inputStream, options, context);
                    switch ((ContentHandler.Validity) contentDescription.get(ContentHandler.VALIDITY_PROPERTY)) {
                        case VALID: {
                            return contentDescription;
                        }
                        case INDETERMINATE: {
                            if (result == null) {
                                result = contentDescription;
                            }
                            break;
                        }
                        case INVALID: {
                            break;
                        }
                    }
                }
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return result == null ? ContentHandler.INVALID_CONTENT_DESCRIPTION : result;
    }

    /**
     * If a stream can be created the file exists. Specialized support is
     * provided for HTTP connections to avoid fetching the whole stream in that
     * case.
     */
    @Override
    public boolean exists(URI uri, Map<?, ?> options)
    {
        return false;
    }

    @Override
    public void exists(URI uri, Map<?, ?> options, Callback<Boolean> callback)
    {
        callback.onSuccess(false);
    }

    @Override
    public Map<String, ?> getAttributes(URI uri, Map<?, ?> options)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        // Set<String> requestedAttributes = getRequestedAttributes(options);
        // try {
        // if (requestedAttributes == null
        // || requestedAttributes.contains(URIConverter.ATTRIBUTE_READ_ONLY))
        // {
        // result.put(URIConverter.ATTRIBUTE_READ_ONLY, true);
        // }
        //
        // if (requestedAttributes == null
        // || requestedAttributes.contains(URIConverter.ATTRIBUTE_TIME_STAMP))
        // {
        // result.put(URIConverter.ATTRIBUTE_TIME_STAMP,
        // urlConnection.getLastModified());
        // }
        //
        // if (requestedAttributes == null
        // || requestedAttributes.contains(URIConverter.ATTRIBUTE_LENGTH))
        // {
        //
        // result.put(URIConverter.ATTRIBUTE_LENGTH,
        // urlConnection.getContentLength());
        // }
        // }
        // catch (IOException exception) {
        // // Ignore exceptions.
        // }
        return result;
    }

    @Override
    public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options)
            throws IOException
    {
        // We can't update any properties via just a URL connection.
    }
}
