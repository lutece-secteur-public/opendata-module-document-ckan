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
 * Package Tag
 */
public class PackageTag
{
    private String _strVocabularyId;
    private String _strDisplayName;
    private String _strName;
    private String _strRevisionTimestamp;
    private String _strState;
    private String _strId;

    /**
     * @return the vocabulary_id
     */
    public String getVocabulary_id()
    {
        return _strVocabularyId;
    }

    /**
     * @param strVocabularyId the vocabulary_id to set
     */
    public void setVocabulary_id(String strVocabularyId)
    {
        _strVocabularyId = strVocabularyId;
    }

    /**
     * @return the display_name
     */
    public String getDisplay_name()
    {
        return _strDisplayName;
    }

    /**
     * @param strDisplayName the display_name to set
     */
    public void setDisplay_name(String strDisplayName)
    {
        _strDisplayName = strDisplayName;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return _strName;
    }

    /**
     * @param strName the name to set
     */
    public void setName(String strName)
    {
        _strName = strName;
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

    /**
     * @return the state
     */
    public String getState()
    {
        return _strState;
    }

    /**
     * @param strState the state to set
     */
    public void setState(String strState)
    {
        _strState = strState;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return _strId;
    }

    /**
     * @param strId the id to set
     */
    public void setId(String strId)
    {
        _strId = strId;
    }
}
