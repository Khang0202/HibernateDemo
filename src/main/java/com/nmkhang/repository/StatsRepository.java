/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmkhang.repository;

import com.nmkhang.hibernatedemov1.HibernateUtils;
import com.nmkhang.pojo.Category;
import com.nmkhang.pojo.OrderDetail;
import com.nmkhang.pojo.Product;
import com.nmkhang.pojo.SaleOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsRepository {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public List<Object[]> countProductByCate() {
        try (Session session = HibernateUtils.getSESSION_FACTORY().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rC = q.from(Category.class);

            q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));
            q.where(b.equal(rP.get("category"), rC.get("id")));
            q.groupBy(rC.get("id"));
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }

    public List<Object[]> StatsRevenue(Map<String, String> params) throws ParseException {
        try (Session session = HibernateUtils.getSESSION_FACTORY().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rO = q.from(OrderDetail.class);
            Root rS = q.from(SaleOrder.class);

            q.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rO.get("unitPrice"), rO.get("num"))));
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(b.equal(rP.get("id"), rO.get("productId")));
            predicates.add(b.equal(rO.get("orderId"), rS.get("id")));

            if (params != null) {
                String fromDay = params.get("fromDay");
                if (fromDay != null && !fromDay.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(rS.get("createdDate"), FORMAT.parse(fromDay)));
                }
                String toDay = params.get("toDay");
                if (toDay != null && !toDay.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(rS.get("createdDate"), FORMAT.parse(toDay)));
                }
                String quarter = params.get("quarter");
                if (quarter != null && !quarter.isEmpty()) {
                    String year = params.get("year");
                    if (year != null && !year.isEmpty()) {
                        predicates.addAll(Arrays.asList(
                                b.equal(b.function("year", Integer.class, rS.get("createdDate")), Integer.parseInt(year)),
                                b.equal(b.function("quarter", Integer.class, rS.get("createdDate")), Integer.parseInt(quarter))
                        ));
                    }
                }
                b.function("month", Integer.class, rS.get("createdDate"));
                b.function("year", Integer.class, rS.get("createdDate"));
                b.function("quarter", Integer.class, rS.get("createdDate"));
            }
            q.where(predicates.toArray(Predicate[]::new));
            q.groupBy(rP.get("id"));
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
}
