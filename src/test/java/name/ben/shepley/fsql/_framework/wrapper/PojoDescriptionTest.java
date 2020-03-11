package name.ben.shepley.fsql._framework.wrapper;


import name.ben.shepley.fsql._harness.database.h2.model.Orders;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PojoDescriptionTest {
    @Test
    public void build() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PojoDescription<Orders> p = new PojoDescription<>(Orders.class);

        Map<String, Object> fields = new HashMap<>();
        fields.put("ordNum", 1);
        fields.put("ordAmount", new BigDecimal("3.35"));
        fields.put("advanceAmount", new BigDecimal("5.50"));
        fields.put("ordDate", LocalDate.now());
        fields.put("custCode", "Ben");
        fields.put("agentCode", "Aaron");
        fields.put("ordDescription", "growls");

        Orders o = p.build(fields);

        assertThat(o.getOrdNum(), equalTo(1));
        assertThat(o.getOrdAmount(), equalTo(new BigDecimal("3.35")));
        assertThat(o.getAdvanceAmount(), equalTo(new BigDecimal("5.50")));
        assertThat(o.getOrdDate(), equalTo(LocalDate.now()));
        assertThat(o.getCustCode(), equalTo("Ben"));
        assertThat(o.getAgentCode(), equalTo("Aaron"));
        assertThat(o.getOrdDescription(), equalTo("growls"));
    }
}
