package CheckDuplicate;

import CheckDuplicate.HammingUtils;
import CheckDuplicate.SimHashUtils;
import CheckDuplicate.TxtIOUtils;

public class Main {

    public static void main(String[] args) {
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = TxtIOUtils.readTxt(args[0]);  // 读取原文的绝对路径
        String str1 = TxtIOUtils.readTxt(args[1]);  // 读取抄袭版论文的绝对路径
        String resultFileName = args[2];  // 输出答案文件的绝对路径

        // 由字符串得出对应的 simHash值
        String simHash0 = SimHashUtils.getSimHash(str0);
        String simHash1 = SimHashUtils.getSimHash(str1);

        // 由 simHash值求出相似度
        double similarity = HammingUtils.repeatability(simHash0, simHash1);

        // 把相似度写入最后的结果文件中
        TxtIOUtils.writeTxt(similarity, resultFileName);
        System.out.println("相似度录入文件成功！");

        // 退出程序
        System.exit(0);
    }

}