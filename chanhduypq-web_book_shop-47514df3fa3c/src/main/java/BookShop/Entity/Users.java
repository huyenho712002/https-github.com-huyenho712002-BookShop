//package BookShop.Entity;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//
//public class Users {
//	private long id_account;
//	@Valid
//	@NotEmpty(message = "Email khong duoc de trong")
//	private String user;
//	@Valid
//	@NotEmpty(message= "Số điện thoại không được để trống ")
//	private String phone;
//	@Valid
//	@NotEmpty(message = "Password không được để trống")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{6,50}$", message = "password ph?i ch? k� t? hoa, 6-50 k� t?")
//	private String password;
//	@Valid
//    @NotEmpty(message = "Họ Tên không được để trống")
//	private String display_name;
//	
//	private String address;
//
//	public Users() {
//	}
//
//	public Users(long id_account, @Valid @NotEmpty(message = "Email khong duoc de trong") String user,
//			@Valid @NotEmpty(message = "So dien thoai khong duoc de trong ") String phone,
//			@Valid @NotEmpty(message = "Password khong duoc de trong")
//			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{6,50}$", message = "password ph?i ch? k� t? hoa, 6-50 k� t?") String password,
//			@Valid @NotEmpty(message = "Ho ten khong duoc de trong") String display_name, String address) {
//		super();
//		this.id_account = id_account;
//		this.user = user;
//		this.phone = phone;
//		this.password = password;
//		this.display_name = display_name;
//		this.address = address;
//	}
//
//	public long getId_account() {
//		return id_account;
//	}
//
//	public void setId_account(long id_account) {
//		this.id_account = id_account;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getDisplay_name() {
//		return display_name;
//	}
//
//	public void setDisplay_name(String display_name) {
//		this.display_name = display_name;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	@Override
//	public String toString() {
//		return "Users [id_account=" + id_account + ", user=" + user + ", phone=" + phone + ", password=" + password + ", display_name="
//				+ display_name + ", address=" + address + "]";
//	}
//
//}
