/*
 * Copyright (c) 2002-2014, Mairie de Paris
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
package fr.paris.lutece.plugins.document.modules.ckan.rs;

import com.sun.jersey.api.Responses;

import fr.paris.lutece.plugins.document.modules.ckan.business.WSBase;
import fr.paris.lutece.plugins.document.modules.ckan.service.MapperService;
import fr.paris.lutece.plugins.document.modules.ckan.service.PackageServiceV3;
import fr.paris.lutece.plugins.rest.service.RestConstants;

import org.apache.log4j.Logger;

import org.xml.sax.SAXException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;


/**
 * Ckan Web services API implementation
 */
@Path( RestConstants.BASE_PATH + Constants.PATH_CKAN_API )
public class CkanRest
{
    private static final int VERSION_3 = 3;
    private Logger _logger = Logger.getLogger( RestConstants.REST_LOGGER );

    /**
     * Get package list
     * @param nVersion The API version
     * @return the list in JSON format
     */
    @GET
    @Path( Constants.PATH_GET_PACKAGE_LIST )
    @Produces( MediaType.APPLICATION_JSON )
    public String getPackageList( @PathParam( "version" )
    int nVersion )
    {
        _logger.debug( "getPackageList - api version " + nVersion );

        switch ( nVersion )
        {
            case VERSION_3:
                return getPackageListV3(  );

            default:
                break;
        }

        throw new WebApplicationException( Responses.NOT_FOUND );
    }

    /**
     * Get package list for the API version 3
     * @return the list in JSON format
     */
    private String getPackageListV3(  )
    {
        WSBase response = PackageServiceV3.getPackageList(  );

        return MapperService.getJson( response );
    }

    /**
     * Get a given package
     * @param nVersion The API version
     * @param strIdPackage The package ID
     * @return The package data in JSON format
     * @throws SAXException If an error occurs
     */
    @GET
    @Path( Constants.PATH_GET_PACKAGE_SHOW )
    @Produces( MediaType.APPLICATION_JSON )
    public String getPackageShow( @PathParam( "version" )
    int nVersion, @QueryParam( Constants.PARAMETER_ID )
    String strIdPackage ) throws SAXException
    {
        _logger.debug( "getPackageShow - api version " + nVersion );

        switch ( nVersion )
        {
            case VERSION_3:
                return getPackageShowV3( strIdPackage );

            default:
                break;
        }

        throw new WebApplicationException( Responses.NOT_FOUND );
    }

    /**
     * Get a given package for the API version 3
     * @param strIdPackage The package ID
     * @return The package data in JSON format
     * @throws SAXException If an error occurs
     */
    private String getPackageShowV3( String strIdPackage )
        throws SAXException
    {
        _logger.debug( "getPackageShowV3" );

        String strId = strIdPackage;
        int nPos = strIdPackage.indexOf( "-" );

        if ( nPos > 0 )
        {
            strId = strIdPackage.substring( 0, nPos );
        }

        WSBase response = PackageServiceV3.getPackageShow( strId );

        return MapperService.getJson( response );
    }
}
