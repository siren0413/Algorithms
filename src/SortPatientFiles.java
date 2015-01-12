
public class SortPatientFiles {
	public static void sortFiles(PFile[] files){
		if(files == null || files.length ==0) return;
		int i = 0, j = files.length-1;
		while(i < files.length && files[i].p==Priority.High_importance) i++;
		while(j >=0 && files[j].p == Priority.Low_importance)j--;
		int k = i+1;
		while(k < j){
			if(k > i && files[k].p == Priority.High_importance){
				swap(files, i++, k);
			}else if(k < j && files[k].p == Priority.Low_importance){
				swap(files, j--, k);
			}else{
				k++;
			}
		}
	}
	
	private static void swap(PFile[] files, int i, int j){
		PFile file = files[i];
		files[i] = files[j];
		files[j] = file;
	}
	
	public static void main(String[] args) {
		PFile[] files = new PFile[7];
		files[0] = new PFile(Priority.Mid_importance);
		files[1] = new PFile(Priority.Low_importance);
		files[2] = new PFile(Priority.High_importance);
		files[3] = new PFile(Priority.High_importance);
		files[4] = new PFile(Priority.Low_importance);
		files[5] = new PFile(Priority.Mid_importance);
		files[6] = new PFile(Priority.High_importance);
		sortFiles(files);
		for(PFile file: files){
			System.out.println(file.p);
		}
	}
}

class PFile{
	Priority p;
	String name;
	public PFile(Priority p){
		this.p = p;
		name="";
	}
}

enum Priority{
	High_importance("high"),
	Mid_importance("mid"),
	Low_importance("low");
	
	String name;
	Priority(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
