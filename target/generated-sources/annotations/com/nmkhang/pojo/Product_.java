package com.nmkhang.pojo;

import com.nmkhang.pojo.Category;
import com.nmkhang.pojo.Comment;
import com.nmkhang.pojo.OrderDetail;
import com.nmkhang.pojo.ProdTag;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-07T03:13:23", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, Date> createdDate;
    public static volatile CollectionAttribute<Product, OrderDetail> orderDetailCollection;
    public static volatile CollectionAttribute<Product, ProdTag> prodTagCollection;
    public static volatile SingularAttribute<Product, Long> price;
    public static volatile CollectionAttribute<Product, Comment> commentCollection;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Boolean> active;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, String> manufacturer;

}