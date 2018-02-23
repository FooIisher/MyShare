package leetcode;
/**
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note: 
 * The solution is guaranteed to be unique.
 * @author fish
 *
 * ������ֻ��һ��������ֻ�д����start������
 * �ſ�������ȫ�̡���Ҳָ����һ����ʵ���Ǿ���
 * ����������������ߵ�start-1ʱ�޷�����һ��
 * ��start�����Ե����ֱ���ʣ��������<0ʱ����һ��
 * ���п�������������㣬�����ǲ��ǣ�Ҫ���ܵ�����
 * ���ǲ��Ǵ���0
 */
public class gasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null||gas.length==0||cost.length==0){
        	return -1;
        }
        
        int remain = 0, index =-1,total=0;
        for(int i=0;i<gas.length;i++){
        	total += gas[i] - cost[i];
        	remain += gas[i] - cost[i];
        	if(remain<0){
        		remain =0;
        		index = i;
        	}
        }
        return total>=0?index+1:-1;
    }
}
