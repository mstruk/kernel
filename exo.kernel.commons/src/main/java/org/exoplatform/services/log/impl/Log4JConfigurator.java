/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.log.impl;

import org.apache.log4j.PropertyConfigurator;
import org.exoplatform.commons.utils.SecurityHelper;
import org.exoplatform.services.log.AbstractLogConfigurator;

import java.security.PrivilegedAction;
import java.util.Properties;

/**
 * Created by The eXo Platform SAS. 
 * 
 * <br/> Log4J configurator. The properties are the same as log4j.properties file's name value pairs.
 *  
 * @author <a href="mailto:gennady.azarenkov@exoplatform.com">Gennady Azarenkov</a>
 * @version $Id: Log4JConfigurator.java 34394 2009-07-23 09:23:31Z dkatayev $
 */
public class Log4JConfigurator extends AbstractLogConfigurator
{
   public void configure(final Properties properties)
   {
      SecurityHelper.doPriviledgedAction(new PrivilegedAction<Object>()
      {
         public Object run()
         {
            PropertyConfigurator.configure(properties);
            return null;
         }
      });
      this.properties = properties;
   }
}
