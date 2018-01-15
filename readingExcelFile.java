import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.collect.Table.Cell;


public class readingExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\MMMM0918\\Desktop\\deepanshi.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// We will pass the name / index of the sheet which starts from '0'.
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		XSSFRow row;
		XSSFCell cell;
		//We will iterate all the rows in the sheet
		
	String username= sheet.getRow(1).getCell(0).getStringCellValue();
	String password= sheet.getRow(1).getCell(1).getStringCellValue();

	System.out.println(username);
	System.out.println(password);
	WebDriver driver;
	System.setProperty("webdriver.firefox.marionette", "C:\\Sripts\\drivers\\geckodriver.exe");
	 driver = new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get("https://www.gmail.com");
	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).clear();
	driver.findElement(By.id("identifierId")).sendKeys(username);
	driver.findElement(By.id("identifierNext")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.id("passwordNext")).click();
String title= driver.getTitle();
XSSFCell cell2=sheet.getRow(0).createCell(2);
cell2.setCellType(cell2.CELL_TYPE_STRING);
cell2.setCellValue(title);
System.out.println(title);
FileOutputStream fos=new FileOutputStream("C:\\Users\\MMMM0918\\Desktop\\deepanshi.xlsx");
wb.write(fos);
	}
}
