package com.tp;

import com.tp.dao.IDao;
import com.tp.entities.Category;
import com.tp.entities.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestHibernateConfig.class)
@Transactional
@Rollback
public class AppTest {

    @Autowired
    private IDao<Category> categoryDao;

    @Autowired
    private IDao<Product> productDao;

    @Test
    public void testCreateAndFind() {
        Category c = new Category();
        c.setName("Cat1");
        categoryDao.create(c);
        Assert.assertTrue(c.getId() > 0);

        Product p = new Product();
        p.setName("Prod1");
        p.setPrice(10.0);
        p.setCategory(c);
        productDao.create(p);

        Product fromDb = productDao.findById(p.getId());
        Assert.assertNotNull(fromDb);
        Assert.assertEquals("Prod1", fromDb.getName());
        Assert.assertNotNull(fromDb.getCategory());
        Assert.assertEquals("Cat1", fromDb.getCategory().getName());
    }
}

