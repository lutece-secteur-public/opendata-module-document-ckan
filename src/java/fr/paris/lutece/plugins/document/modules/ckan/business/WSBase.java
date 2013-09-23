/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.document.modules.ckan.business;

/**
 * WSBase
 */
public abstract class WSBase
{
    
    private String _strHelp;
    private boolean _bSuccess = true;

    /**
     * @return the _strHelp
     */
    public String getHelp(  )
    {
        return _strHelp;
    }

    /**
     * @param strHelp the _strHelp to set
     */
    public void setHelp( String strHelp )
    {
        _strHelp = strHelp;
    }

    /**
     * @return the _bSuccess
     */
    public boolean isSuccess(  )
    {
        return _bSuccess;
    }

    /**
     * @param bSuccess the _bSuccess to set
     */
    public void setSuccess( boolean bSuccess )
    {
        _bSuccess = bSuccess;
    }
    
}
