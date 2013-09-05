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
package fr.paris.lutece.plugins.document.modules.ckan.service;

import fr.paris.lutece.plugins.document.business.Document;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.string.StringUtil;

import java.util.Map;


/**
 * CkanService
 */
public class CkanService
{
    public static final String NOT_FOUND = "not found";

    private static final String PROPERTY_RESOURCE_URL_FORMAT = "document-ckan.resourceUrlFormat";
    private Map<String, String> _mappings;
    private Map<String, String> _defaults;

    /**
     * Sets the mappings (injected)
     * @param mappings 
     */
    public void setMappings( Map mappings )
    {
        _mappings = mappings;
    }
    
    /**
     * Sets defaults (injected)
     * @param defaults 
     */
    public void setDefaults( Map defaults )
    {
        _defaults = defaults;
    }

    /**
     * Return the resource URL format
     * @return the resource URL format 
     */
    public String getResourceUrlFormat(  )
    {
        return AppPropertiesService.getProperty( PROPERTY_RESOURCE_URL_FORMAT );
    }

    /**
     * Get the mapping value for a given key
     * @param strKey The key
     * @return The value
     */
    public String getMapping( String strKey )
    {
        String strMapping = _mappings.get( strKey );

        if ( strMapping != null )
        {
            return strMapping;
        }

        AppLogService.info( "CKAN Mapping not found for key " + strKey );

        return "";
    }

    /**
     * Get a default value for a given key
     * @param strKey The Key
     * @return The value
     */
    public String getDefault( String strKey )
    {
        String strDefault = _defaults.get( strKey );

        if ( strDefault != null )
        {
            return strDefault;
        }

        AppLogService.info( "CKAN default not found for key " + strKey );

        return "";
    }

    /**
     * Build the name ID
     * @param doc The document
     * @return The ID
     */
    public static String getNameId( Document doc )
    {
        String strID = "" + doc.getId(  ) + "-" + doc.getSummary(  );
        strID = StringUtil.replaceAccent( strID );

        return strID.replace( " ", "_" );
    }
}
