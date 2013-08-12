/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the format
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

    /**
     * @return the mimetype
     */
    public String getMimetype()
    {
        return mimetype;
    }

    /**
     * @param mimetype the mimetype to set
     */
    public void setMimetype(String mimetype)
    {
        this.mimetype = mimetype;
    }

    /**
     * @return the url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * @return the resource_type
     */
    public String getResource_type()
    {
        return resource_type;
    }

    /**
     * @param resource_type the resource_type to set
     */
    public void setResource_type(String resource_type)
    {
        this.resource_type = resource_type;
    }

    /**
     * @return the created
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(String created)
    {
        this.created = created;
    }

    /**
     * @return the last_modified
     */
    public String getLast_modified()
    {
        return last_modified;
    }

    /**
     * @param last_modified the last_modified to set
     */
    public void setLast_modified(String last_modified)
    {
        this.last_modified = last_modified;
    }
    
}
