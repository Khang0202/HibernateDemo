package com.nmkhang.pojo;

import com.nmkhang.pojo.ProdTag;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-07T03:13:23", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Tag.class)
public class Tag_ { 

    public static volatile CollectionAttribute<Tag, ProdTag> prodTagCollection;
    public static volatile SingularAttribute<Tag, String> name;
    public static volatile SingularAttribute<Tag, Integer> id;
    public static volatile SingularAttribute<Tag, String> tagcol;

}