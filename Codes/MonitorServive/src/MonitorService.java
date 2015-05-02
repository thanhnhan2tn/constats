import java.io.IOException;

public class MonitorService {

	// Ham thuc thi chinh
	public String ExecuteProcess(String[] cmd) throws InterruptedException {
		try {
			Process child = Runtime.getRuntime().exec(cmd);
			child.waitFor();
			// Print the first 16 bytes of its output
			java.io.InputStream i = child.getInputStream();
			byte[] b = new byte[60];
			i.read(b, 0, b.length);
			String kq = new String(b);
			return kq;

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	// get mem total
	public String getMemTotal() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"cat /proc/meminfo | grep 'MemTotal' | awk '{print $2}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem.replace("kB", "");

	}

	// get mem used
	public String getMemUsage() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c", "free | grep Mem | awk '{print $4}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get mem free
	public String getMemFree() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c", "free | grep Mem | awk '{print $3}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get mem total
	public String getCpuUsage() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"top -b -n1 | grep 'Cpu(s)'|awk '{print $2}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get total local disk
	public String getTotalLocalDisk() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"df -h | grep /dev/mapper/ubuntu--vg-root |awk '{print $2}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get used local disk
	public String getUsedLocalDisk() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"df -h | grep /dev/mapper/ubuntu--vg-root|awk '{print $3}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get free local disk
	public String getFreeLocalDisk() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"df -h | grep /dev/mapper/ubuntu--vg-root|awk '{print $4}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	// get User Percent local disk
	public String getusePercentLocalDisk() throws InterruptedException {

		// String command = "ls /etc | grep release";
		String[] cmd = { "/bin/sh", "-c",
				"df -h | grep /dev/mapper/ubuntu--vg-root|awk '{print $5}'" };
		String kqMem = ExecuteProcess(cmd);
		return kqMem;

	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		MonitorService test = new MonitorService();
		// System.out.println(test.getMemTotal());
		// System.out.println(test.getMemUsage());
		// System.out.println(test.getMemFree());
		// System.out.println(test.getCpuUsage());
		// System.out.println(test.getTotalLocalDisk());
		// System.out.println(test.getUsedLocalDisk());
		// System.out.println(test.getFreeLocalDisk());
		// System.out.println(test.getusePercentLocalDisk());
		System.out.println("Tao doi duong");

		ServerInfo svInfo = new ServerInfo(test.getCpuUsage(),
				test.getMemTotal(), test.getMemUsage(), test.getMemFree(),
				test.getTotalLocalDisk(), test.getUsedLocalDisk(),
				test.getFreeLocalDisk());

		System.out.println(svInfo.getMemTotal());
		System.out.println(svInfo.getMemUsage());
		System.out.println(svInfo.getMemFree());
		System.out.println(svInfo.getCpuUsage());
		System.out.println(svInfo.getTotalLocalDisk());
		System.out.println(svInfo.getUsedLocalDisk());
		System.out.println(svInfo.getFreeLocalDisk());

	}
}
