/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2010 by:
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
package org.deegree.services.controller.exception.serializer;

import org.deegree.services.controller.ImplementationMetadata;
import org.deegree.workspace.Workspace;

/**
 * A provider can be used to provide multiple exception serializers for multiple services,
 * identified by their implementation metadata.
 *
 * @author <a href="mailto:schmitz@lat-lon.de">Andreas Schmitz</a>
 * @author last edited by: $Author$
 * @version $Revision$, $Date$
 */
public interface SerializerProvider {

	/**
	 * Called before anything else, so configuration files can be loaded etc.
	 * @param workspace
	 */
	void init(Workspace workspace);

	/**
	 * @param metadata
	 * @return true, if the provider wants to serialize exceptions for the service
	 * implementation specified by its metadata
	 */
	boolean matches(ImplementationMetadata<?> metadata);

	/**
	 * @param metadata
	 * @param originalSerializer the originally selected serializer
	 * @return an exception serializer for the specified service. Must not return null if
	 * matches(metadata) would return true.
	 */
	ExceptionSerializer getSerializer(ImplementationMetadata<?> metadata, ExceptionSerializer originalSerializer);

}
