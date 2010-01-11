/**
 * Copyright Quickoffice, Inc, 2005-2009
 * 
 * NOTICE: The intellectual and technical concepts contained herein are proprietary to Quickoffice, Inc. and is
 * protected by trade secret and copyright law. Dissemination of any of this information or reproduction of this
 * material is strictly forbidden unless prior written permission is obtained from Quickoffice, Inc.
 * 
 * Created: Jan 9, 2010 Author: rohitghatol
 * 
 */

package com.punegtug.gadget.wave.jira.client.settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.punegtug.gadget.wave.jira.client.mvc.Observable;

/**
 * Model class for JiraWave Settings
 * 
 * @author rohitghatol
 * 
 */
public class SettingsPanelModel extends Observable
{

	private boolean completeMode = false;
	private String jiraURL = null;
	private final List<String> prefixes = new ArrayList<String>();
	private String jiraId = null;
	private String userName = null;
	private String password = null;


	public void setValues(final WaveGadgetUserPreference userPreferences)
	{
		jiraURL = userPreferences.jiraURL().getValue();
	}


	/**
	 * @return the jiraURL
	 */
	public String getJiraURL()
	{
		return jiraURL;
	}


	/**
	 * @param jiraURL the jiraURL to set
	 */
	public void setJiraURL(final String jiraURL)
	{
		this.jiraURL = jiraURL;
	}


	/**
	 * @return the jiraId
	 */
	public String getJiraId()
	{
		return jiraId;
	}


	/**
	 * @param jiraId the jiraId to set
	 */
	public void setJiraId(final String jiraId)
	{
		this.jiraId = jiraId;
	}


	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(final String userName)
	{
		this.userName = userName;
	}


	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}


	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(final String e)
	{
		return prefixes.add(e);
	}


	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clearPrefixList()
	{
		prefixes.clear();
	}


	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public String getPrefix(final int index)
	{
		return prefixes.get(index);
	}


	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isPrefixListEmpty()
	{
		return prefixes.isEmpty();
	}


	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<String> prefixIterator()
	{
		return prefixes.iterator();
	}


	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public String removePrefix(final int index)
	{
		return prefixes.remove(index);
	}


	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int prefixSize()
	{
		return prefixes.size();
	}


	/**
	 * @return the prefixes
	 */
	public List<String> getPrefixes()
	{
		return prefixes;
	}


	public void setPrefixes(final List<String> prefixes)
	{
		this.prefixes.clear();
		if ( null != prefixes )
		{
			this.prefixes.addAll(prefixes);
		}
	}


	public void setPrefixes(final String[] prefixes)
	{
		this.prefixes.clear();
		if ( null != prefixes )
		{
			for ( final String prefix : prefixes )
			{
				this.prefixes.add(prefix);
			}
		}
	}


	/**
	 * @return the completeMode
	 */
	public boolean isCompleteMode()
	{
		return completeMode;
	}


	/**
	 * @param completeMode the completeMode to set
	 */
	public void setCompleteMode(final boolean completeMode)
	{
		this.completeMode = completeMode;
	}

}
