package lv.javaguru.java3OnlineBanking.core.database.clients;

import lv.javaguru.java3OnlineBanking.Application;
import lv.javaguru.java3OnlineBanking.core.database.api.ClientDAO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DatabaseHibernateTest {

    @Autowired
    protected ClientDAO clientDAO;
}

