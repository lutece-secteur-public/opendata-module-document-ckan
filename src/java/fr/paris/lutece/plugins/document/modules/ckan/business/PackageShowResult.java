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
    private String _strId;
    private String _strTitle;
    private String _strName;
    private String _strAuthor;
    private String _strAuthorEmail;
    private String _strState;
    private String _strVersion;
    private String _strType;
    private String _strMaintainer;
    private boolean _bIsOpen;
    private String _strUrl;
    private String _strNotes;
    private List<PackageResource> _resources;
    private PackageOrganization _organization;
    private String _strMetadataCreated;
    private String _strMetadataModified;
    private int _nNumResources;
    private String _strRevisionId;
    private String _strRevisionTimestamp;
    

    /**
     * @return the id
     */
    public String getId(  )
    {
        return _strId;
    }

    /**
     * @param id the id to set
     */
    public void setId( String id )
    {
        _strId = id;
    }

    /**
     * @return the title
     */
    public String getTitle(  )
    {
        return _strTitle;
    }

    /**
     * @param title the title to set
     */
    public void setTitle( String title )
    {
        _strTitle = title;
    }

    /**
     * @return the name
     */
    public String getName(  )
    {
        return _strName;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        _strName = name;
    }

    /**
     * @return the author
     */
    public String getAuthor(  )
    {
        return _strAuthor;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor( String author )
    {
        _strAuthor = author;
    }

    /**
     * @return the author_email
     */
    public String getAuthor_email(  )
    {
        return _strAuthorEmail;
    }

    /**
     * @param author_email the author_email to set
     */
    public void setAuthor_email( String author_email )
    {
        _strAuthorEmail = author_email;
    }

    /**
     * @return the state
     */
    public String getState(  )
    {
        return _strState;
    }

    /**
     * @param state the state to set
     */
    public void setState( String state )
    {
        _strState = state;
    }

    /**
     * @return the version
     */
    public String getVersion(  )
    {
        return _strVersion;
    }

    /**
     * @param version the version to set
     */
    public void setVersion( String version )
    {
        _strVersion = version;
    }

    /**
     * @return the type
     */
    public String getType(  )
    {
        return _strType;
    }

    /**
     * @param type the type to set
     */
    public void setType( String type )
    {
        _strType = type;
    }

    /**
     * @return the maintainer
     */
    public String getMaintainer(  )
    {
        return _strMaintainer;
    }

    /**
     * @param maintainer the maintainer to set
     */
    public void setMaintainer( String maintainer )
    {
        _strMaintainer = maintainer;
    }

    /**
     * @return the isopen
     */
    public boolean isIsopen(  )
    {
        return _bIsOpen;
    }

    /**
     * @param isopen the isopen to set
     */
    public void setIsopen( boolean isopen )
    {
        _bIsOpen = isopen;
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
     * @return the notes
     */
    public String getNotes(  )
    {
        return _strNotes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes( String notes )
    {
        _strNotes = notes;
    }

    /**
     * @return the resources
     */
    public List<PackageResource> getResources(  )
    {
        return _resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources( List<PackageResource> resources )
    {
        _resources = resources;
    }

    /**
     * @return the organization
     */
    public PackageOrganization getOrganization(  )
    {
        return _organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization( PackageOrganization organization )
    {
        _organization = organization;
    }
    
    /**
     * @return the metadata_created
     */
    public String getMetadata_created(  )
    {
        return _strMetadataCreated;
    }

    /**
     * @param strMetadataCreated the metadata_created to set
     */
    public void setMetadata_created( String strMetadataCreated )
    {
        _strMetadataCreated = strMetadataCreated;
    }

    /**
     * @return the metadata_modified
     */
    public String getMetadata_modified(  )
    {
        return _strMetadataModified;
    }

    /**
     * @param strMetadataModified the metadata_modified to set
     */
    public void setMetadata_modified( String strMetadataModified )
    {
        _strMetadataModified = strMetadataModified;
    }

    /**
     * @return the num_resources
     */
    public int getNum_resources()
    {
        return _nNumResources;
    }

    /**
     * @param nNumResources the num_resources to set
     */
    public void setNum_resources(int nNumResources)
    {
        _nNumResources = nNumResources;
    }

    /**
     * @return the revision_id
     */
    public String getRevision_id()
    {
        return _strRevisionId;
    }

    /**
     * @param strRevisionId the revision_id to set
     */
    public void setRevision_id(String strRevisionId)
    {
        _strRevisionId = strRevisionId;
    }

    /**
     * @return the revision_timestamp
     */
    public String getRevision_timestamp()
    {
        return _strRevisionTimestamp;
    }

    /**
     * @param strRevisionTimestamp the revision_timestamp to set
     */
    public void setRevision_timestamp(String strRevisionTimestamp)
    {
        _strRevisionTimestamp = strRevisionTimestamp;
    }
}
