/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2012 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -
 and
 - Occam Labs UG (haftungsbeschränkt) -

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

 Occam Labs UG (haftungsbeschränkt)
 Godesberger Allee 139, 53175 Bonn
 Germany

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/
package org.deegree.feature.persistence.shape;

import java.io.File;

import org.deegree.commons.xml.jaxb.JAXBUtils;
import org.deegree.feature.persistence.FeatureStore;
import org.deegree.feature.persistence.shape.jaxb.ShapeFeatureStoreConfig;
import org.deegree.workspace.ResourceBuilder;
import org.deegree.workspace.ResourceInitException;
import org.deegree.workspace.ResourceLocation;
import org.deegree.workspace.Workspace;
import org.deegree.workspace.standard.AbstractResourceMetadata;
import org.deegree.workspace.standard.AbstractResourceProvider;
import org.deegree.workspace.standard.DefaultWorkspace;

/**
 * TODO add class documentation here
 *
 * @author <a href="mailto:schmitz@occamlabs.de">Andreas Schmitz</a>
 * @author last edited by: $Author: stranger $
 * @version $Revision: $, $Date: $
 */
public class ShapeFeatureStoreMetadata extends AbstractResourceMetadata<FeatureStore> {

	public ShapeFeatureStoreMetadata(Workspace workspace, ResourceLocation<FeatureStore> location,
			AbstractResourceProvider<FeatureStore> provider) {
		super(workspace, location, provider);
	}

	@Override
	public ResourceBuilder<FeatureStore> prepare() {
		try {
			ShapeFeatureStoreConfig config = (ShapeFeatureStoreConfig) JAXBUtils.unmarshall(
					ShapeFeatureStoreProvider.CONFIG_JAXB_PACKAGE, provider.getSchema(), location.getAsStream(),
					workspace);
			return new ShapeFeatureStoreBuilder(config, location, this);
		}
		catch (Exception e) {
			throw new ResourceInitException(e.getLocalizedMessage(), e);
		}
	}

	public static void main(String[] args) {
		Workspace ws = new DefaultWorkspace(
				new File("/home/stranger/.deegree/deegree-workspace-utah-3.2-pre9-20120717.234406-9"));
		ws.initAll();
		ws.destroy();
	}

}
