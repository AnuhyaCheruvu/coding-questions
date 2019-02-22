package csv; /**
 * Created by anuhyacheruvu on 21/11/17.
 */
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    static int useID = 10001;
    static int mcc_id = 001;

    static Map<String, Integer> userMap = new HashMap<>();
    static Map<String, Integer> mccMap = new HashMap<>();



    public static void main(String[] args) {
        try {
            CsvReader transactions = new CsvReader("testData.csv");
            CsvWriter csvOutput = null;
            transactions.readHeaders();

            while(transactions.readRecord()) {
                Data data = new Data();
                data.yearMonth = transactions.get("Year-Month");
                data.agencyNumber = transactions.get("Agency Number");
                data.agencyName = transactions.get("Agency Name");
                data.cardholderLastName = transactions.get("Cardholder Last Name");
                data.cardholderFirstInitial = transactions.get("Cardholder First Initial");
                data.description = transactions.get("Description");
                data.amount = transactions.get("Amount");
                data.vendor = transactions.get("Vendor");
                data.transactionDate = transactions.get("Transaction Date");
                data.postedDate = transactions.get("Posted Date");
                data.mcc = transactions.get("Merchant Category Code (MCC)");

                String outputFile = "mcc_output.csv";
                boolean alreadyExists = new File(outputFile).exists();

                csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

                if(!alreadyExists) {
                    csvOutput.write("userId");
                    csvOutput.write("Year-Month");
                    csvOutput.write("Agency Number");
                    csvOutput.write("Agency Name");
                    csvOutput.write("Cardholder Last Name");
                    csvOutput.write("Cardholder First Initial");
                    csvOutput.write("Description");
                    csvOutput.write("Amount");
                    csvOutput.write("Vendor");
                    csvOutput.write("Transaction Date");
                    csvOutput.write("Posted Date");
                    csvOutput.write("mcc_id");
                    csvOutput.write("Merchant Category Code (MCC)");

                    csvOutput.endRecord();



                }
                data.cardholderLastName = data.cardholderLastName.replace(",",".");
                data.mcc = data.mcc.replace(",","-");
                data.vendor = data.vendor.replace(",","-");
                String name = data.cardholderLastName.concat(data.cardholderFirstInitial);
                if(userMap.containsKey(name)) {
                    data.userId = userMap.get(name);
                }
                else {
                    data.userId = useID;
                    userMap.put(name, useID++);
                }
                if(mccMap.containsKey(data.mcc)) {
                    data.mccId = mccMap.get(data.mcc);
                }
                else {
                    data.mccId= mcc_id++;
                    mccMap.put(data.mcc, (int) data.mccId);
                    csvOutput.write(String.valueOf(data.mccId));
                    csvOutput.write(data.mcc);

                    csvOutput.endRecord();
                }
                csvOutput.write(String.valueOf(data.userId));
                csvOutput.write(data.yearMonth);
                csvOutput.write(data.agencyNumber);
                csvOutput.write(data.agencyName);
                csvOutput.write(data.cardholderLastName);
                csvOutput.write(data.cardholderFirstInitial);
                csvOutput.write(data.description);
                csvOutput.write(data.amount);
                csvOutput.write(data.vendor);
                csvOutput.write(data.transactionDate);
                csvOutput.write(data.postedDate);
                csvOutput.write(data.mcc);







                csvOutput.close();
            }
            transactions.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
