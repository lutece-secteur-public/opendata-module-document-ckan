/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.document.modules.ckan.business;


/**
 * Package Resource
 */
public class PackageResource
{
    private String _strDescription;
    private String _strFormat;
    private String _strMimetype;
    private String _strUrl;
    private String _strResourceType;
    private String _strCreated;
    private String _strLastModified;
    private String _strSize;

    /**
     * @return the description
     */
    public String getDescription(  )
    {
        return _strDescription;
    }

    /**
     * @param description the description to set
     */
    public void setDescription( String description )
    {
        _strDescription = description;
    }

    /**
     * @return the format
     */
    public String getFormat(  )
    {
        return _strFormat;
    }

    /**
     * @param format the format to set
     */
    public void setFormat( String format )
    {
        _strFormat = format;
    }

    /**
     * @return the mimetype
     */
    public String getMimetype(  )
    {
        return _strMimetype;
    }

    /**
     * @param mimetype the mimetype to set
     */
    public void setMimetype( String mimetype )
    {
        _strMimetype = mimetype;
    }

    /**
     * @return the url
     */
    public String getUrl(  )
    {
        return _strUrl;
    }

    /**
     * @param url the url to set
     */
    public void setUrl( String url )
    {
        _strUrl = url;
    }

    /**
     * @return the resource_type
     */
    public String getResource_type(  )
    {
        return _strResourceType;
    }

    /**
     * @param resource_type the resource_type to set
     */
    public void setResource_type( String resource_type )
    {
        _strResourceType = resource_type;
    }

    /**
     * @return the created
     */
    public String getCreated(  )
    {
        return _strCreated;
    }

    /**
     * @param created the created to set
     */
    public void setCreated( String created )
    {
        _strCreated = created;
    }

    /**
     * @return the last_modified
     */
    public String getLast_modified(  )
    {
        return _strLastModified;
    }

    /**
     * @param last_modified the last_modified to set
     */
    public void setLast_modified( String last_modified )
    {
        _strLastModified = last_modified;
    }

    /**
     * @return the size
     */
    public String getSize()
    {
        return _strSize;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size)
    {
        _strSize = size;
    }
}
