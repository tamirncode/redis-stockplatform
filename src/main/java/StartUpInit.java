import com.example.stockplatform.stockapp.service.StockIngest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartUpInit {
  @Autowired
  StockIngest stockIngest;

  @PostConstruct
  public void init(){
     stockIngest.ingestStock();
  }
}