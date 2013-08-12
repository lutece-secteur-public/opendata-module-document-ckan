/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.document.modules.ckan.business;

/**
 *
 * @author pierre
 */
public class PackageShow
{
    private String _strHelp;
    private boolean _bSuccess;
    private PackageShowResult _result;

        /**
     * @return the _strHelp
     */
    public String getHelp()
    {
        return _strHelp;
    }

    /**
     * @param strHelp the _strHelp to set
     */
    public void setHelp(String strHelp)
    {
        this._strHelp = strHelp;
    }

    /**
     * @return the _bSuccess
     */
    public boolean isSuccess()
    {
        return _bSuccess;
    }

    /**
     * @param bSuccess the _bSuccess to set
     */
    public void setSuccess(boolean bSuccess)
    {
        this._bSuccess = bSuccess;
    }

    /**
     * @return the _listResult
     */
    public PackageShowResult getResult()
    {
        return _result;
    }

    /**
     * @param listResult the _listResult to set
     */
    public void setResult(PackageShowResult result)
    {
        _result = result;
    }
    

}
