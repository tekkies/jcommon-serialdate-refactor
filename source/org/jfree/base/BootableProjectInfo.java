/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 * 
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 
 * USA.  
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 * 
 * ------------------------
 * BootableProjectInfo.java
 * ------------------------
 * (C)opyright 2004, by Thomas Morgner and Contributors.
 *
 * Original Author:  Thomas Morgner;
 * Contributor(s):   David Gilbert (for Object Refinery Limited);
 *
 * $Id: BootableProjectInfo.java,v 1.3 2005/10/18 13:13:58 mungady Exp $
 *
 * Changes
 * -------
 * 07-Jun-2004 : Added source headers (DG);
 *
 */

package org.jfree.base;

import java.util.ArrayList;

/**
 * Project info for a bootable project. A bootable project provides a controlled
 * way of initalizing all subsystems by providing a Boot loader implementation.
 *
 * @author Thomas Morgner
 */
public class BootableProjectInfo extends BasicProjectInfo {

    /** The dependencies. */
    private ArrayList dependencies;

    /** The boot class. */
    private String bootClass;
    
    /** The auto-boot flag. */
    private boolean autoBoot;

    /**
     * Creates a new instance.
     */
    public BootableProjectInfo() {
        this.dependencies = new ArrayList();
        this.autoBoot = true;
    }

    /**
     * Creates a new library reference.
     *
     * @param name    the name.
     * @param version the version.
     * @param licence the licence.
     * @param info    the web address or other info.
     */
    public BootableProjectInfo(final String name, final String version,
                               final String licence, final String info) {
        this();
        setName(name);
        setVersion(version);
        setLicenceName(licence);
        setInfo(info);
    }

    /**
     * Creates a new library reference.
     *
     * @param name    the name.
     * @param version the version.
     * @param info  the info (for example, the project URL).
     * @param copyright  the copyright statement.
     * @param licenceName the license name.
     */
    public BootableProjectInfo(final String name, final String version, final String info,
                               final String copyright, final String licenceName) {
        this();
        setName(name);
        setVersion(version);
        setLicenceName(licenceName);
        setInfo(info);
        setCopyright(copyright);
    }

    /**
     * Returns the dependencies.
     * 
     * @return The dependencies.
     */
    public BootableProjectInfo[] getDependencies() {
        return (BootableProjectInfo[]) this.dependencies.toArray
            (new BootableProjectInfo[this.dependencies.size()]);
    }

    /**
     * Adds a dependency.
     * 
     * @param projectInfo  the project.
     */
    public void addDependency(final BootableProjectInfo projectInfo) {
        if (projectInfo == null) {
            throw new NullPointerException();
        }
        this.dependencies.add(projectInfo);
    }

    /**
     * Returns the name of the boot class.
     * 
     * @return The name of the boot class.
     */
    public String getBootClass() {
        return this.bootClass;
    }

    /**
     * Sets the boot class name.
     * 
     * @param bootClass  the boot class name.
     */
    public void setBootClass(final String bootClass) {
        this.bootClass = bootClass;
    }

    /**
     * Returns, whether the project should be booted automaticly.
     * 
     * @return The auto-boot flag.
     */
    public boolean isAutoBoot() {
        return this.autoBoot;
    }

    /**
     * Sets the auto boot flag.
     *
     * @param autoBoot true, if the project should be booted automaticly, false otherwise.
     */
    public void setAutoBoot(final boolean autoBoot) {
        this.autoBoot = autoBoot;
    }
    
}
