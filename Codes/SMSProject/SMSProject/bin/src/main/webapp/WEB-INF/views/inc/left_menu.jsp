<!-- left menu for include in jsp view -->
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
	if(session.getAttribute("User")==null){
	    response.sendRedirect("index"); 
	}
%>
<div class="col-lg-3 col-md-3">
	<div class="panel-group" id="accordion">
		<!-- BEGIN collapseZero -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="index"><span class="fa fa-home fa-lg"> </span>Trang
						chủ</a>
				</h4>
			</div>
			<div id="collapseZero" class="panel-collapse collapse"></div>
		</div>
		<!-- END collapseZero -->
		<!-- BEGIN collapseOne -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"><span class="fa fa-shopping-cart fa-lg">
					</span>Quản lý hóa đơn mua hàng</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="PurchaseOrder">Nhập hóa đơn mua hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="PurchaseOrderList">Danh sách hóa đơn mua hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseOne -->
		<!-- BEGIN collapseTwo -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo"><span class="fa fa-th-large fa-lg">
					</span>Quản lý hóa đơn bán hàng</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="createNewSalesOrderForm">Nhập hóa đơn bán hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="SalesOrder">Danh sách hóa đơn bán hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseTwo -->
		<!-- BEGIN collapseThree -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree"><span class="fa fa-dollar fa-lg">
					</span>Quản lý thanh toán của NPP</a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="DistributorPayment">Nhà phân phối thanh toán</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="DistributorPaymentList">Danh sách hóa đơn thanh toán</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseThree -->
		<!-- BEGIN collapseFour -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFour"><span class="fa fa-dollar fa-lg">
					</span>Quản lý thanh toán của KH</a>
				</h4>
			</div>
			<div id="collapseFour" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="">Khách hàng thanh toán</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="">Danh sách hóa đơn thanh toán</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseFour -->
		<!-- BEGIN collapseFive -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFive"><span class="fa fa-thumbs-down fa-lg">
					</span>Quản lý trả lại hàng</a>
				</h4>
			</div>
			<div id="collapseFive" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-mail-reply fa-lg text-primary"></span><a
								href="">Khách hàng trả lại hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-mail-reply fa-lg text-primary"></span><a
								href="">Nhân viên bán hàng trả hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-mail-reply fa-lg text-primary"></span><a
								href="DistributorReturnProduct">Nhà phân phối trả hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseFive -->
		<!-- BEGIN collapseSix -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseSix"><span class="fa fa-dropbox fa-lg">
					</span>Quản lý kho</a>
				</h4>
			</div>
			<div id="collapseSix" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="nhapkiemke">Nhập thông tin kiểm kê kho</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="danhsachkiemke">Danh sách kiểm kê kho</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="">Nhập phiếu xuất kho</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="">Danh sách phiếu xuất kho</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Xem chi tiết phiếu xuất kho</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseSix -->
		<!-- BEGIN collapseSeven -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseSeven"><span class="fa fa-folder fa-lg">
					</span>Quản lý danh mục mặt hàng</a>
				</h4>
			</div>
			<div id="collapseSeven" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="addItemForm">Nhập thông tin mặt hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="itemList">Danh mục mặt hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseSeven -->
		<!-- BEGIN collapseEight -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseEight"><span class="fa fa-users fa-lg">
					</span>Quản lý danh sách khách hàng</a>
				</h4>
			</div>
			<div id="collapseEight" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="">Nhập thông tin khách hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="">Xem danh sách khách hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseEight -->
		<!-- BEGIN collapseNine -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseNine"><span class="fa fa-user fa-lg"> </span>Quản
						lý nhân viên bán hàng</a>
				</h4>
			</div>
			<div id="collapseNine" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-edit fa-lg text-primary"></span><a
								href="">Nhập thông tin nhân viên bán hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-list fa-lg text-primary"></span><a
								href="">Danh sách nhân viên bán hàng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseNine -->
		<!-- BEGIN collapseTen -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTen"><span class="fa fa-file-text fa-lg">
					</span>Báo cáo</a>
				</h4>
			</div>
			<div id="collapseTen" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo danh mục mặt hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo danh sách khách hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo danh sách nhân viên bán hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo tồn kho</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo công nợ khách hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo tồn kho của nhân viên bán hàng</a></td>
						</tr>
						<tr>
							<td><span class="fa fa-file-text fa-lg text-primary"></span><a
								href="">Báo cáo công nợ quá hạng</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- END collapseTen -->
	</div>
</div>
