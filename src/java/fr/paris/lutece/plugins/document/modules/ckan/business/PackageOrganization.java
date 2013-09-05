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
 * PackageOrganization
 */
public class PackageOrganization
{
    private String _strId;
    private String _strName;
    private String _strTitle;
    private String _strType;
    private String _strDescription;
    private String _strApprovalStatus;
    private String _strState;
    private boolean _strIsOrganization;

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
     * @return the approval_status
     */
    public String getApproval_status(  )
    {
        return _strApprovalStatus;
    }

    /**
     * @param approval_status the approval_status to set
     */
    public void setApproval_status( String approval_status )
    {
        _strApprovalStatus = approval_status;
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
     * @return the is_organization
     */
    public boolean isIs_organization(  )
    {
        return _strIsOrganization;
    }

    /**
     * @param is_organization the is_organization to set
     */
    public void setIs_organization( boolean is_organization )
    {
        _strIsOrganization = is_organization;
    }
}
