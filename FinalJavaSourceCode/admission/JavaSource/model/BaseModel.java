package model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseModel implements Serializable{

	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 7766184319541530720L;
	
	/**
	 * The identify of the object
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Common implement equals method
	 */
	public boolean equals( Object obj )
	{
		if( this==obj ) return true;
		
		if( !( obj instanceof BaseModel ) )
			return false;
		
		BaseModel target = (BaseModel)obj;
		
		if( this.getId()!=null && this.getId()>0 )
		{
			return this.getId().equals( target.getId() );
		}
		
		if( target.getId()!=null && target.getId()>0 )
		{
			return false;
		}
		
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Generate the hash code
	 */
	public int hashCode()
	{
		if( this.getId()!=null && this.getId()>0 )
		{
			return this.getId().hashCode();
		}
			
		return HashCodeBuilder.reflectionHashCode(this);
		
		
		
	}

	/**
	 * Common implement toString method
	 */
	public String toString()
	{
		return ToStringBuilder.reflectionToString( this );
	}
}
