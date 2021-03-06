package com.tuyang.test.testCollection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tuyang.beanutils.BeanCopyUtils;

public class Test05 {
	
	private FromBean getFromBean() {
		FromBean fromBean = new FromBean();
		fromBean.setBeanInt(100);
		fromBean.setBeanLong(200);
		fromBean.setBeanString("Test test Test test.");
		
		FromBean2 bean2 = new FromBean2();
		bean2.setBeanFloat(10.4f);
		bean2.setBeanString("bean2");
		
		List<FromBean2> list = new ArrayList<>();
		list.add(bean2);
		list.add(bean2);
		fromBean.setBeanList(list);
		
		return fromBean;
	}

	@Test
	public void testCollection() {
		FromBean fromBean = getFromBean();
		ToBean toBean = BeanCopyUtils.copyBean(fromBean, ToBean.class);
		assertEquals( toBean.getBeanList().size(), 2 );
		assertEquals( fromBean.getBeanInt(), toBean.getBeanInt().intValue() );
		assertEquals( fromBean.getBeanLong(), toBean.getBeanLong());
		assertEquals( fromBean.getBeanString(), toBean.getBeanString() );
	}
	
	@Test
	public void testCollection2() {
		FromBean fromBean = getFromBean();
		List<FromBean> fromList = new ArrayList<>();
		fromList.add(fromBean);
		fromList.add(fromBean);
		fromList.add(fromBean);
		
		List<ToBean> toList = BeanCopyUtils.copyList(fromList, ToBean.class);
		
		assertEquals(toList.size(), 3);
		
		assertEquals( fromBean.getBeanInt(), toList.get(0).getBeanInt().intValue() );
		assertEquals( fromBean.getBeanLong(), toList.get(1).getBeanLong());
		assertEquals( fromBean.getBeanString(), toList.get(2).getBeanString() );
		
	}
}

