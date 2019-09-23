# gRPC


## Giới thiệu gRPC

gRPC là một cơ chế truyền tải (transport) gửi và nhận các tin nhắn giữa hai hệ thống. Hai hệ thống này theo truyền thống là một máy chủ và một máy khách. Như chúng ta đã tìm hiểu, RPC có thể được triển khai trong Go để truyền tải JSON. Chúng ta gọi nó là một RPC JSON service. Tương tự, Google RPC được thiết kế đặc biệt để truyền tải dữ liệu dưới dạng Protocol Buffers.
gRPC làm cho việc tạo service dễ dàng và thanh lịch. Nó cung cấp một bộ API tốt để định nghĩa service và chạy chúng. Trong phần này, chúng ta sẽ chủ yếu tập trung vào cách tạo một gRPC service và sử dụng nó.
Ưu điểm chính của gRPC là nó có thể được hiểu bởi nhiều ngôn ngữ lập trình và Protocol Buffers cung cấp một cấu trúc dữ liệu chung. Vì vậy, sự kết hợp này cho phép truyền thông liền mạch giữa các stack công nghệ và hệ thống khác nhau. Đây là khái niệm không thể thiếu của điện toán phân tán.
Square, Netflix… thúc đẩy gRPC để mở rộng các service có lưu lượng truy cập lớn. Người quản lý sản phẩm cũ của Google, Andrew Jessup, cho biết trong một cuộc họp tại Google, hàng tỷ cuộc gọi gRPC được xử lý mỗi ngày. Do đó, nếu bất kỳ tổ chức kinh doanh nào cần nắm lấy những gì Google làm, tổ chức đó cũng có thể xử lý nhu cầu lưu lượng với những điều chỉnh này trong các service.
GRPC có các lợi ích sau so với kiến trúc HTTP/REST/JSON truyền thống:
- GRPC sử dụng HTTP/2 là giao thức nhị phân
- Nén header trong HTTP/2, có nghĩa là ít chi phí hơn
- Ghép nhiều yêu cầu trên một kết nối
- Sử dụng sự nghiêm ngặt của protobufs cho dữ liệu
- Streaming các resquest hoặc response thay vì giao dịch (transactions) request/response

## Streaming hai chiều với gRPC

Ưu điểm chính của GRPC so với HTTP/1.1 truyền thống là nó sử dụng một kết nối TCP duy nhất để gửi và nhận nhiều tin nhắn giữa máy chủ và máy khách. Một trường hợp sử dụng thực tế khác là GPS được lắp đặt trong taxi. Ở đây, taxi là máy khách gửi các vị trí địa lý của nó đến máy chủ dọc theo tuyến đường của nó. Cuối cùng, máy chủ có thể tính tổng số tiền vé tùy thuộc vào thời gian giữa các điểm và tổng khoảng cách.
Một trường hợp khác là khi một máy chủ cần thông báo cho máy khách bất cứ khi nào một số xử lý được thực hiện. Đây được gọi là server push model. Máy chủ có thể gửi luồng kết quả lại khi máy khách chỉ yêu cầu họ một lần. Điều này khác với polling, nơi mà máy khách yêu cầu một cái gì đó mỗi lần. Điều này có thể hữu ích khi có một loạt các bước cần thời gian thực hiện. GRPC client có thể chuyển công việc đó đến máy chủ GRPC. Sau đó, máy chủ phải mất thời gian của nó và chuyển tiếp tin nhắn trở lại cho máy khách, đọc chúng và làm một cái gì đó hữu ích. Khái niệm này tương tự như WebSockets, nhưng giữa bất kỳ nền tảng nào.
Có những trường hợp khác cũng có thể được triển khai với bộ đệm giao thức và GRPC:
- Máy khách gửi yêu cầu được stream để nhận được phản hồi cuối cùng từ máy chủ
- Máy khách và máy chủ đều gửi yêu cầu và phản hồi được stream cùng một lúc

## Tài liệu tham khảo
https://codenotfound.com/grpc-java-example.html
https://github.com/sfcodes/grpc-client-spring-boot
https://thongthele.blogspot.com/2019/01/lam-viec-voi-protocol-buffers-va-grpc.html
https://github.com/code-not-found/grpc-java/tree/master/grpc-java-hello-world
https://www.baeldung.com/grpc-introduction