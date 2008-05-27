/*
    JSPWiki - a JSP-based WikiWiki clone.

    Copyright (C) 2001-2006 Janne Jalkanen (Janne.Jalkanen@iki.fi)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2.1 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.ecyrd.jspwiki.event;

/**
 *  WikiPageRenameEvent extends WikiPageEvent to indicate a change in
 *  the name of a WikiPage.
 *  <p>
 *  This reuses {@link #getPageName()} to return the new name of the
 *  page, with {@link #getOldPageName()} returning the old name.
 *
 * @author  Murray Altheim
 * @see     com.ecyrd.jspwiki.event.WikiPageEvent
 * @since   2.5.108
 */
public class WikiPageRenameEvent extends WikiPageEvent
{
    private static final long serialVersionUID = 1L;

    /** Indicates a page rename event. This is based on events
      * generated by {@link com.ecyrd.jspwiki.PageRenamer}. */
    public static final int PAGE_RENAMED         = 28;

    private String m_oldpagename  = null;

    // ............


    /**
     *  Constructs an instance of this event.
     *
     * @param src    the Object that is the source of the event.
     * @param oldname   the old name of the WikiPage being acted upon.
     * @param newname   the new name of the WikiPage being acted upon.
     */
    public WikiPageRenameEvent( Object src, String oldname, String newname )
    {
        super( src, PAGE_RENAMED, newname );
        m_oldpagename = oldname;
    }


   /**
     * Returns the old Wiki page name associated with this event.
     * This may be null if unavailable.
     *
     * @return     the old Wiki page name associated with this WikiEvent, or null.
     */
    public String getOldPageName()
    {
        return m_oldpagename;
    }


   /**
     * Returns the new Wiki page name associated with this event. This
     * returns the same value as the superclass' {@link #getPageName()}.
     * This may be null if unavailable.
     *
     * @return     the new Wiki page name associated with this WikiEvent, or null.
     */
    public String getNewPageName()
    {
        return super.getPageName();
    }


   /**
     * Returns true if the int value is a WikiPageRenameEvent type.
     */
    public static boolean isValidType( int type )
    {
        return type >= PAGE_LOCK && type <= PAGE_RENAMED;
    }


    /**
     * Returns a textual representation of the event type.
     * @return a String representation of the type
     */
    public String eventName()
    {
        return "PAGE_RENAMED";
    //  switch ( getType() )
    //  {
    //      case PAGE_RENAMED:         return "PAGE_RENAMED";
    //      default:                   return super.eventName();
    //  }
    }


   /** Returns a human-readable description of the event type.
     * @return a String description of the type
     */
    public String getTypeDescription()
    {
        return "page renamed event";
    //  switch ( getType() )
    //  {
    //      case PAGE_RENAMED:         return "page renamed event";
    //      default:                   return super.getTypeDescription();
    //  }
    }

} // end class com.ecyrd.jspwiki.event.WikiPageRenameEvent
