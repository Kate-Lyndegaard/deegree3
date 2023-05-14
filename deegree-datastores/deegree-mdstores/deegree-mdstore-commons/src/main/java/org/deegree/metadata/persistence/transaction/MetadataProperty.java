/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2009 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/
package org.deegree.metadata.persistence.transaction;

import org.deegree.filter.expression.ValueReference;

/**
 * To specify individual property values to be updated.
 *
 * @author <a href="mailto:thomas@lat-lon.de">Steffen Thomas</a>
 * @author last edited by: $Author: mschneider $
 * @version $Revision: 30340 $, $Date: 2011-04-04 16:05:42 +0200 (Mo, 04. Apr 2011) $
 */
public class MetadataProperty {

	private ValueReference propertyName;

	private Object replacementValue;

	/**
	 * To specify individual property values to be updated.
	 * @param propertyName can be a string or an XPath-expression [1..1]
	 * @param replacementValue can be anyType [0..1]
	 */
	public MetadataProperty(ValueReference propertyName, Object replacementValue) {
		this.propertyName = propertyName;
		this.replacementValue = replacementValue;
	}

	/**
	 * @return the propertyName element contains the name of a property to be updated. The
	 * name may be a path expression.
	 */
	public ValueReference getPropertyName() {
		return propertyName;
	}

	/**
	 * @return the replacementValue element contains the replacement value for the named
	 * property.
	 */
	public Object getReplacementValue() {
		return replacementValue;
	}

}
