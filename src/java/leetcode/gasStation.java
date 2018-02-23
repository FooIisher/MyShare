package leetcode;
/**
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note: 
 * The solution is guaranteed to be unique.
 * @author fish
 *
 * 解有且只有一个，所以只有从起点start处出发
 * 才可以走完全程。这也指出了一个事实：那就是
 * 从另外的起点出发，走到start-1时无法走下一步
 * 到start，所以当出现本次剩余汽油量<0时，下一步
 * 就有可能是真正的起点，至于是不是，要看总得汽油
 * 量是不是大于0
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
