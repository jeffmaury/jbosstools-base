/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.common.model.loaders.impl;

import org.jboss.tools.common.model.*;
import org.jboss.tools.common.model.loaders.*;
import org.jboss.tools.common.model.util.*;

public class BodyLoader implements XObjectLoader {

    public BodyLoader() {}

    public void load(XModelObject object) {
        String body = XModelObjectLoaderUtil.getTempBody(object);
        object.setAttributeValue(XModelObjectConstants.ATTR_NAME_BODY, body);
    }

    public boolean update(XModelObject object) throws XModelException {
        load(object);
        return true;
    }

    public boolean save(XModelObject object) {
        if(!object.isModified()) return true;
        XModelObjectLoaderUtil.setTempBody(object, object.getAttributeValue(XModelObjectConstants.ATTR_NAME_BODY));
        return true;
    }
}
