package controller;

public class a {
	public static void main(String[] args) {
		String chuoi = "16/17 Đường Hoàng Diệu, Phường Tây Lộc, Thành Phố Huế"; // Thay đổi chuỗi theo nhu cầu của bạn

		// Tạo biểu thức chính quy để kiểm tra chew
		String regex = "\\d+.*\\/.*\\s+[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+";

		// Kiểm tra xem chuỗi có khớp với biểu thức chính quy không
		boolean a = chuoi.matches(regex);

		System.out.println(a);
	}

}
