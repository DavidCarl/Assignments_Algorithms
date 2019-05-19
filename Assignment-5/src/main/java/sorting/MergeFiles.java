package sorting;

import java.io.*;
import java.util.ArrayList;

public class MergeFiles {
    public MergeFiles () {};

    public void mergeFiles() {

        File sortedFile = new File("Files/Sorted/SortedFile.txt");
        if (sortedFile != null) {
            sortedFile.delete();
        }

        System.out.println("Started merging the files together");

        File directory = new File("Files/split");
        File[] files = directory.listFiles();
        int noFiles =  files.length;

        try {
            ArrayList<FileReader> mergeFr = new ArrayList();
            ArrayList<BufferedReader> mergeBr = new ArrayList();
            ArrayList<Float> floats = new ArrayList();
            FileWriter fw = new FileWriter("Files/Sorted/SortedFile.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            boolean someFilesStillHasLine = false;

            for (int i = 0; i < noFiles; i++) {
                mergeFr.add(new FileReader(files[i]));
                mergeBr.add(new BufferedReader(mergeFr.get(i)));

                String line = mergeBr.get(i).readLine();
                if(line != null) {
                    floats.add(Float.parseFloat(line));
                    someFilesStillHasLine = true;
                } else {
                    floats.add(null);
                }
            }
            Float chosen;
            int cnt = 0;
            while(someFilesStillHasLine) {
                Float min;
                int minIndex = 0;

                chosen = floats.get(0);
                if (chosen != null) {
                    min = chosen;
                    minIndex = 0;
                } else {
                    min = null;
                    minIndex = -1;
                }

                // Check which one is smallest
                for (int i = 1; i <floats.size(); i++) {
                    chosen = floats.get(i);
                    if(min != null) {
                        if (chosen != null && chosen < min) {
                            minIndex = i;
                            min = floats.get(i);
                        }
                    } else {
                        if (chosen != null) {
                            min = chosen;
                            minIndex = i;
                        }
                    }
                }

                if (minIndex < 0) {
                    someFilesStillHasLine = false;
                } else {
                    // write to the sorted file
                    bw.append(floats.get(minIndex).toString() + "\n");

                    // get another float from the file that had  the min
                    String line = mergeBr.get(minIndex).readLine();
                    if (line != null) {
                        floats.set(minIndex, Float.parseFloat(line));
                    } else {
                        floats.set(minIndex, null);
                    }
                }
                // check if one still has float
                for (int i = 0; i <floats.size(); i++) {
                    someFilesStillHasLine = false;
                    if (floats.get(i) != null) {
                        if (minIndex < 0) {
                            System.out.println("Min index at 0 and found float not null " + floats.get(i));
                        }
                        someFilesStillHasLine = true;
                        break;
                    }
                }

                // check the actual file one more time
                if (!someFilesStillHasLine) {
                    // write the last one not covered above
                    for (int i = 0; i < floats.size(); i++) {
                        if (floats.get(i) == null) {
                            String line = mergeBr.get(i).readLine();
                            if (line!=null) {
                                someFilesStillHasLine=true;
                                floats.set(i,Float.parseFloat(line));
                            }
                        }
                    }
                }
            }

            // close all the files
            bw.close();
            fw.close();
            for(int i=0; i<mergeBr.size(); i++)
                mergeBr.get(i).close();
            for(int i=0; i<mergeFr.size(); i++)
                mergeFr.get(i).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
