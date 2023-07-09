//package BookShop.Entity;
//
//import java.io.Serializable;
//import java.sql.Date;
//
//import org.springframework.web.multipart.MultipartFile;
//
//public class Product implements Serializable  {
//	private int id;
//	private String name;
//	private double price;
//	private Author author;
//	private Categorys category;
//	private int quantityRemain;
//	private String description;
//	private String publisher;
//	private Date publish_year;
//	private float avg_rating;
//	private String img;
//	private String is_deteled;
//	private static final long serialVersionUID = 1L;
//	private MultipartFile multipartFile;
//	private Date createdAt;
//	public MultipartFile getMultipartFile() {
//		return multipartFile;
//	}
//	public void setMultipartFile(MultipartFile multipartFile) {
//		this.multipartFile = multipartFile;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	public void setNewBook(int newBook) {
//		this.newBook = newBook;
//	}
//	private Date updatedAt;
//	private int isDeleted;
//	private int newBook;
//	private int highLight;
//	public Product() {
//
//	}
//	public Product(int id, String name, double price, Author author, Categorys category, int quantityRemain,
//			String description, String publisher, Date publish_year, float avg_rating, String img, Date createdAt,
//			Date updatedAt, int isDeleted, int newBook, int highLight) {
//	
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.author = author;
//		this.category = category;
//		this.quantityRemain = quantityRemain;
//		this.description = description;
//		this.publisher = publisher;
//		this.publish_year = publish_year;
//		this.avg_rating = avg_rating;
//		this.img = img;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.isDeleted = isDeleted;
//		this.newBook = newBook;
//		this.highLight = highLight;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	public Author getAuthor() {
//		return author;
//	}
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
//	public Categorys getCategory() {
//		return category;
//	}
//	public void setCategory(Categorys category) {
//		this.category = category;
//	}
//	public int getQuantityRemain() {
//		return quantityRemain;
//	}
//	public void setQuantityRemain(int quantityRemain) {
//		this.quantityRemain = quantityRemain;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getPublisher() {
//		return publisher;
//	}
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}
//	public Date getPublish_year() {
//		return publish_year;
//	}
//	public void setPublish_year(Date date) {
//		this.publish_year = date;
//	}
//	public float getAvg_rating() {
//		return avg_rating;
//	}
//	public void setAvg_rating(float avg_rating) {
//		this.avg_rating = avg_rating;
//	}
//	public String getImg() {
//		return img;
//	}
//	public void setImg(String img) {
//		this.img = img;
//	}
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//	public int getIsDeleted() {
//		return isDeleted;
//	}
//	public void setIsDeleted(int isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//	public int getNewBook() {
//		return newBook;
//	}
//	public void setNewBooks(int newBook) {
//		this.newBook = newBook;
//	}
//	public int getHighLight() {
//		return highLight;
//	}
//	public void setHighLight(int highLight) {
//		this.highLight = highLight;
//	}
//	public String getIs_deteled() {
//		return is_deteled;
//	}
//	public void setIs_deteled(String is_deteled) {
//		this.is_deteled = is_deteled;
//	}
//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", category="
//				+ category + ", quantityRemain=" + quantityRemain + ", description=" + description + ", publisher="
//				+ publisher + ", publish_year=" + publish_year + ", avg_rating=" + avg_rating + ", img=" + img
//				+ ", is_deteled=" + is_deteled + ", multipartFile=" + multipartFile + ", createdAt=" + createdAt
//				+ ", updatedAt=" + updatedAt + ", isDeleted=" + isDeleted + ", newBook=" + newBook + ", highLight="
//				+ highLight + ", getMultipartFile()=" + getMultipartFile() + ", getId()=" + getId() + ", getName()="
//				+ getName() + ", getPrice()=" + getPrice() + ", getAuthor()=" + getAuthor() + ", getCategory()="
//				+ getCategory() + ", getQuantityRemain()=" + getQuantityRemain() + ", getDescription()="
//				+ getDescription() + ", getPublisher()=" + getPublisher() + ", getPublish_year()=" + getPublish_year()
//				+ ", getAvg_rating()=" + getAvg_rating() + ", getImg()=" + getImg() + ", getCreatedAt()="
//				+ getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", getIsDeleted()=" + getIsDeleted()
//				+ ", getNewBook()=" + getNewBook() + ", getHighLight()=" + getHighLight() + ", getIs_deteled()="
//				+ getIs_deteled() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
//				+ super.toString() + "]";
//	}
//
//	
//	
//	
//}
