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
 *
 * @author pierre
 */
public class PackageResource
{
    private String description;
    private String format;
    String size;
    private String mimetype;
    private String url;
    private String resource_type;
    private String created;
    private String last_modified;

    /**
     * @return the description
     */
    public String getDescription(  )
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription( String description )
    {
        this.description = description;
    }

    /**
     * @return the format
     */
    public String getFormat(  )
    {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat( String format )
    {
        this.format = format;
    }

    /**
     * @return the mimetype
     */
    public String getMimetype(  )
    {
        return mimetype;
    }

    /**
     * @param mimetype the mimetype to set
     */
    public void setMimetype( String mimetype )
    {
        this.mimetype = mimetype;
    }

    /**
     * @return the url
     */
    public String getUrl(  )
    {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl( String url )
    {
        this.url = url;
    }

    /**
     * @return the resource_type
     */
    public String getResource_type(  )
    {
        return resource_type;
    }

    /**
     * @param resource_type the resource_type to set
     */
    public void setResource_type( String resource_type )
    {
        this.resource_type = resource_type;
    }

    /**
     * @return the created
     */
    public String getCreated(  )
    {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated( String created )
    {
        this.created = created;
    }

    /**
     * @return the last_modified
     */
    public String getLast_modified(  )
    {
        return last_modified;
    }

    /**
     * @param last_modified the last_modified to set
     */
    public void setLast_modified( String last_modified )
    {
        this.last_modified = last_modified;
    }
}
