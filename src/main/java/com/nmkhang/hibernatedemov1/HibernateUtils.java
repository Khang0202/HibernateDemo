/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmkhang.hibernatedemov1;

import com.nmkhang.pojo.Category;
import com.nmkhang.pojo.Comment;
import com.nmkhang.pojo.OrderDetail;
import com.nmkhang.pojo.Product;
import com.nmkhang.pojo.ProdTag;
import com.nmkhang.pojo.SaleOrder;
import com.nmkhang.pojo.User;
import com.nmkhang.pojo.Tag;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        Configuration conf = new Configuration();
        Properties prop = new Properties();
        prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        prop.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        prop.put(Environment.USER, "root");
        prop.put(Environment.PASS, "Admin@123");
        prop.put(Environment.SHOW_SQL,"true");
        
        conf.setProperties(prop);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
                
        SESSION_FACTORY =  conf.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the SESSION_FACTORY
     */
    public static SessionFactory getSESSION_FACTORY() {
        return SESSION_FACTORY;
    }
}
