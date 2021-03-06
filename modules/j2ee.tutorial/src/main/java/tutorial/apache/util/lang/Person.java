package tutorial.apache.util.lang;

import java.util.Date;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.StandardToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import utils.DateUtil;


public class Person {
	private String name;  
	private int age;  
	private Date dateJoined;
	
	public Person() {}
	public Person(String name, int age, Date dateJoined) {
		this.name = name;
		this.age = age;
		this.dateJoined = dateJoined;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	
	public String toString(){
		//return ReflectionToStringBuilder.toString(this);
		//ToStringStyle.DEFAULT_STYLE
		//ToStringStyle.MULTI_LINE_STYLE
		//ToStringStyle.NO_FIELD_NAMES_STYLE
		//ToStringStyle.SHORT_PREFIX_STYLE
		//ToStringStyle.SIMPLE_STYLE
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("name",name)
			.append("age",age)
			.append("dateJoined",DateUtil.toString(dateJoined))
			.toString();
		//return ReflectionToStringBuilder.reflectionToString(this);

	}
	
	private static final StandardToStringStyle STYLE = new StandardToStringStyle();

	static {
		STYLE.setUseShortClassName(true);
		STYLE.setUseIdentityHashCode(false);
		STYLE.setArrayStart("[");
		STYLE.setArraySeparator(", ");
		STYLE.setArrayEnd("]");
		STYLE.setNullText("%NULL%");
		STYLE.setSizeStartText("%SIZE=");
		STYLE.setSizeEndText("%");
		STYLE.setSummaryObjectStartText("%");
		STYLE.setSummaryObjectEndText("%");
	}
	
	public int compareTo(Object obj){
		return CompareToBuilder.reflectionCompare(this,obj);
	}
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	@Override
	public boolean equals(Object obj){
		return EqualsBuilder.reflectionEquals(this,obj);
	}

	public static void main(String[] args){
		System.out.println(new Person("name",20,new Date()).toString());
	}
}
