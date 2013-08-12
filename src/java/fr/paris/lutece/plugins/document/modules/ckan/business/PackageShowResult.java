/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    private String author;
    private String state;
    private String version;
    private String type;
    private String maintainer;
    private List<PackageResource> resources;

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version)
    {
        this.version = version;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @return the maintainer
     */
    public String getMaintainer()
    {
        return maintainer;
    }

    /**
     * @param maintainer the maintainer to set
     */
    public void setMaintainer(String maintainer)
    {
        this.maintainer = maintainer;
    }

    /**
     * @return the resources
     */
    public List<PackageResource> getResources()
    {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List<PackageResource> resources)
    {
        this.resources = resources;
    }
}
