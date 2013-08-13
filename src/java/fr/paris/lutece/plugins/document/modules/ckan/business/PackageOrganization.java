/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.document.modules.ckan.business;


/**
 *
 * @author levy
 */
public class PackageOrganization
{
    private String id;
    private String name;
    private String title;
    private String type;
    private String description;
    private String approval_status;
    private String state;
    private boolean is_organisation;

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
     * @return the description
     */
    public String getDescription(  )
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription( String description )
    {
        this.description = description;
    }

    /**
     * @return the approval_status
     */
    public String getApproval_status(  )
    {
        return approval_status;
    }

    /**
     * @param approval_status the approval_status to set
     */
    public void setApproval_status( String approval_status )
    {
        this.approval_status = approval_status;
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
     * @return the is_organisation
     */
    public boolean isIs_organisation(  )
    {
        return is_organisation;
    }

    /**
     * @param is_organisation the is_organisation to set
     */
    public void setIs_organisation( boolean is_organisation )
    {
        this.is_organisation = is_organisation;
    }
}
