/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included  with this distribution in
 * the LICENSE.txt file.
 */
package org.apache.tools.ant;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;

/**
 * A task for instantiating Ant1 datatypes.
 *
 * @author <a href="mailto:darrell@apache.org">Darrell DeBoer</a>
 * @version $Revision$ $Date$
 */
public class Ant1CompatTypeInstanceTask
    extends Task
{
    public void configure( Configuration configuration ) throws ConfigurationException
    {
        if( configuration.getAttribute( "id", null ) == null )
        {
            final String message = "id is required.";
            throw new ConfigurationException( message );
        }

        String typeName = configuration.getName();
        Object datatype = project.createDataType( getAnt1Name( typeName ) );

        // Configure the datatype. The type is added to the project
        // as a reference during configuration.
        configure( datatype, configuration );
    }

    /**
     * Execute task. Don't do anything.
     */
    public void execute()
    {
        // Everything is done during configuration.
    }
}
