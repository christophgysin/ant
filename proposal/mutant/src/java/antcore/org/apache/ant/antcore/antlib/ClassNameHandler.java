/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Ant", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.ant.antcore.antlib;

import org.apache.ant.antcore.xml.ElementHandler;
import org.xml.sax.SAXParseException;

/**
 * Handler for elements which specify a class
 *
 * @author <a href="mailto:conor@apache.org">Conor MacNeill</a>
 */
public class ClassNameHandler extends ElementHandler {
    /** The classname attribute name */
    public static final String CLASSNAME_ATTR = "classname";

    /**
     * Gets the className of the Converter
     *
     * @return the className value
     */
    public String getClassName() {
        return getAttribute(CLASSNAME_ATTR);
    }

    /**
     * Process the definition element
     *
     * @param elementName the name of the element
     * @exception SAXParseException if there is a problem parsing the
     *      element
     */
    public void processElement(String elementName)
         throws SAXParseException {
        if (getClassName() == null) {
            throw new SAXParseException(CLASSNAME_ATTR + " must be "
                 + "specified for a converter", getLocator());
        }
    }

    /**
     * Validate that the given attribute and value are valid.
     *
     * @param attributeName The name of the attributes
     * @param attributeValue The value of the attributes
     * @exception SAXParseException if the attribute is not allowed on the
     *      element.
     */
    protected void validateAttribute(String attributeName,
                                     String attributeValue)
         throws SAXParseException {
        if (!attributeName.equals(CLASSNAME_ATTR)) {
            throwInvalidAttribute(attributeName);
        }
    }
}


