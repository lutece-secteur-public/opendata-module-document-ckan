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

import java.util.List;


/**
 *
 * @author pierre
 */
public class PackageShowResult
{
    private String id;
    private String title;
    private String name;
    private String author;
    private String author_email;
    private String state;
    private String version;
    private String type;
    private String maintainer;
    private boolean is_open;
    private String url;
    private String notes;
    private List<PackageResource> resources;
    private PackageOrganization organization;

    /**
     * @return the id
     */
    public String getId(  )
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( String id )
    {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle(  )
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle( String title )
    {
        this.title = title;
    }

    /**
     * @return the name
     */
    public String getName(  )
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the author
     */
    public String getAuthor(  )
    {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor( String author )
    {
        this.author = author;
    }

    /**
     * @return the author_email
     */
    public String getAuthor_email(  )
    {
        return author_email;
    }

    /**
     * @param author_email the author_email to set
     */
    public void setAuthor_email( String author_email )
    {
        this.author_email = author_email;
    }

    /**
     * @return the state
     */
    public String getState(  )
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState( String state )
    {
        this.state = state;
    }

    /**
     * @return the version
     */
    public String getVersion(  )
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion( String version )
    {
        this.version = version;
    }

    /**
     * @return the type
     */
    public String getType(  )
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( String type )
    {
        this.type = type;
    }

    /**
     * @return the maintainer
     */
    public String getMaintainer(  )
    {
        return maintainer;
    }

    /**
     * @param maintainer the maintainer to set
     */
    public void setMaintainer( String maintainer )
    {
        this.maintainer = maintainer;
    }

    /**
     * @return the is_open
     */
    public boolean isIs_open(  )
    {
        return is_open;
    }

    /**
     * @param is_open the is_open to set
     */
    public void setIs_open( boolean is_open )
    {
        this.is_open = is_open;
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
     * @return the notes
     */
    public String getNotes(  )
    {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes( String notes )
    {
        this.notes = notes;
    }

    /**
     * @return the resources
     */
    public List<PackageResource> getResources(  )
    {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources( List<PackageResource> resources )
    {
        this.resources = resources;
    }

    /**
     * @return the organization
     */
    public PackageOrganization getOrganization(  )
    {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization( PackageOrganization organization )
    {
        this.organization = organization;
    }
}
