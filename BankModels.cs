using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.SqlClient;
using System.Data;

namespace BankOfBIT_TS.Models
{
    /// <summary>
    /// Represents the Client table in the database.
    /// </summary>
    public class Client
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        [Display(Name = "Client\nID")]
        public int ClientId { get; set; }

      
        [Display(Name = "Client")]
        public long? ClientNumber { get; set; }

        [Required]
        [StringLength(35)]
        [Display(Name = "First\nName")]
        public string FirstName { get; set; }

        [Required]
        [StringLength(35)]
        [Display(Name = "Last\nName")]
        public string LastName { get; set; }

        [Required]
        [StringLength(35)]
        public string Address { get; set; }

        [Required]
        [StringLength(35)]
        public string City { get; set; }

        [Required]
        [RegularExpression("^(N[BLSTU]|[AMN]B|[BQ]C|ON|PE|SK)$", ErrorMessage = "Input must be all capitals and in valid format. Eg. MB")]
        public string Province { get; set; }

        [Required]
        [Display(Name = "Postal\nCode")]
        [RegularExpression("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$", ErrorMessage = "Input must follow valid format. Eg. A1A 1A1")]
        public string PostalCode { get; set; }

        [Required]
        [DisplayFormat(DataFormatString = "{0:d}", ApplyFormatInEditMode = true)]
        [Display(Name = "Date\nCreated")]
        public DateTime DateCreated { get; set; }

        [Display(Name = "Client\nNotes")]
        public string Notes { get; set; }

        /// <summary>
        /// Returns the full name of the client.
        /// </summary>
        [Display(Name = "Name")]
        public string FullName
        {
            get
            {
                return String.Format("{0} {1}", FirstName, LastName);
            }
        }

        /// <summary>
        /// Returns the full address of the client.
        /// </summary>
        [Display(Name = "Address")]
        public string FullAddress
        {
            get
            {
                return String.Format("{0} {1}, {2} {3} ", Address, City, Province, PostalCode);
            }
        }

        /// <summary>
        /// Sets the next client number.
        /// </summary>
        public void SetNetClientNumber()
        {
            ClientNumber = StoredProcedures.NextNumber("NextClientNumbers");
        }

        /// <summary>
        /// Navigational Property.
        /// Represents * on the diagram.
        /// </summary>
        public virtual ICollection<BankAccount> BankAccount { get; set; }
    }

    /// <summary>
    /// Represents the NextClientNumber table.
    /// </summary>
    public class NextClientNumber
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextClientNumber nextClientNumber;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextClientNumberId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextClientNumber()
        {
            this.NextAvailableNumber = 20000000;
        }

        /// <summary>
        /// Creates an instance and only one instance.
        /// </summary>
        /// <returns></returns>
        public static NextClientNumber GetInstance()
        { 
            if (nextClientNumber == null)
            {
                nextClientNumber = db.NextClientNumbers.SingleOrDefault();
                if (nextClientNumber == null)
                {
                    nextClientNumber = new NextClientNumber();
                    db.NextClientNumbers.Add(nextClientNumber);
                    db.SaveChanges();
                }
            } 
            return nextClientNumber;
        }
    }

    /// <summary>
    /// Represents the BankAccount table in the database.
    /// </summary>
    public abstract class BankAccount
    {

        private int state;
        private int oldState;
        BankOfBIT_TSContext bankOfBIT = new BankOfBIT_TSContext();

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        [Display(Name = "Bank\nAccount\nID")]
        public int BankAccountId { get; set; }

        [Display(Name = "Account\nNumber")]
        public long? AccountNumber { get; set; }

        [Required]
        [ForeignKey("Client")]
        [Display(Name = "Client\nID")]
        public int ClientId { get; set; }

        [Required]
        [ForeignKey("AccountState")]
        [Display(Name = "Account\nState")]
        public int AccountStateId { get; set; }

        [Required]
        [Display(Name = "Current\nBalance")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double Balance { get; set; }

        [Required]
        [Display(Name = "Opening\nBalance")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double OpeningBalance { get; set; }

        [Required]
        [DisplayFormat(DataFormatString = "{0:d}", ApplyFormatInEditMode = true)]
        [Display(Name = "Date\nCreated")]
        public DateTime DateCreated { get; set; }

        [Display(Name = "Account\nNotes")]
        public string Notes { get; set; }

        /// <summary>
        /// returns a formatted version of the account type.
        /// </summary>
        [Display(Name = "Account\nType")]
        public string Description
        {
            get
            {
                string type = GetType().Name;

                if (type.Contains("Account"))
                {
                    int length = "Account".Length;
                    type = type.Remove(type.IndexOf("Account"));
                }
                return type;
            }
        }

        /// <summary>
        /// Sets the next account number for the Bank Account.
        /// Overrided in the sub classes 
        /// </summary>
        public void SetNextAccountNumber()
        {
        }

        /// <summary>
        /// Changes the current state of the Bank Account.
        /// </summary>
        public void ChangeState()
        {       
            state = this.AccountStateId;
            oldState = state;
            AccountState AccState = bankOfBIT.AccountStates.Where(X => X.AccountStateId == this.AccountStateId).SingleOrDefault();

            do
            {
                AccState = bankOfBIT.AccountStates.Where(X => X.AccountStateId == this.AccountStateId).SingleOrDefault();
                state = oldState;
                AccState.StateChangeCheck(this);
                oldState = bankOfBIT.AccountStates.Where(X => X.AccountStateId == this.AccountStateId).SingleOrDefault().AccountStateId;

            } while (state != oldState);
        }

        /// <summary>
        /// Represents the client navigability.
        /// 1 on the diagram.
        /// </summary>
        ///        
        public virtual Client Client { get; set; }

        /// <summary>
        /// Represents the AccountState navigability.
        /// 1 on the diagram.
        /// </summary>
        public virtual AccountState AccountState { get; set; }

        /// <summary>
        /// Represents the Transaction navigability 
        /// 0.* on the diagram.
        /// </summary>
        public virtual ICollection<Transaction> Transaction { get; set; }

    }

    /// <summary>
    /// Represents the SavingsAccount state of BankAccount.
    /// </summary>
    public class SavingsAccount : BankAccount
    {
        [Required]
        [Display(Name = "Service\nCharges")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double SavingsServiceCharge { get; set; }

        /// <summary>
        /// Sets the next account number for the savings account.
        /// </summary>
        public void SetNextAccountNumber()
        {
            AccountNumber = StoredProcedures.NextNumber("NextSavingsAccounts");
        }

    }

    /// <summary>
    /// Represents the NextSavingsAccount number.
    /// </summary>
    public class NextSavingsAccount
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextSavingsAccount nextSavingsAccount;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextSavingsAccountId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextSavingsAccount()
        {
            this.NextAvailableNumber = 20000;
        }

        /// <summary>
        /// Creates an instance of NextSavingsAccount and makes sure only one is created.
        /// </summary>
        /// <returns></returns>
        public static NextSavingsAccount GetInstance()
        { 
            if (nextSavingsAccount == null)
            {
                nextSavingsAccount = db.NextSavingsAccounts.SingleOrDefault();
                if (nextSavingsAccount == null)
                {
                    nextSavingsAccount = new NextSavingsAccount();
                    db.NextSavingsAccounts.Add(nextSavingsAccount);
                    db.SaveChanges();
                }
            } 
            return nextSavingsAccount;
        }
    }

    /// <summary>
    /// Represents the MortgageAccount state of BankAccount.
    /// </summary>
    public class MortgageAccount : BankAccount
    {
        [Required]
        [Display(Name="Interest\nRate")]
        [DisplayFormat(DataFormatString = "{0:P}")]
        public double MortgageRate { get; set; }

        [Required]
        [Display(Name="Amortization")]
        public int Amortization { get; set; }

        /// <summary>
        /// Sets the next account number for the Mortgage account.
        /// </summary>
        public void SetNextAccountNumber()
        {
            AccountNumber = StoredProcedures.NextNumber("NextMortgageAccounts");
        }
    }

    /// <summary>
    /// Represents the nextMortgageAccount number.
    /// </summary>
    public class NextMortgageAccount
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextMortgageAccount nextMortgageAccount;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextMortgageAccountId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextMortgageAccount()
        {
            this.NextAvailableNumber = 200000;
        }

        /// <summary>
        /// Creates an instance of NextMortgageAccount and makes sure only one is created.
        /// </summary>
        /// <returns></returns>
        public static NextMortgageAccount GetInstance()
        { 
            if (nextMortgageAccount == null)
            {
                nextMortgageAccount = db.NextMortgageAccounts.SingleOrDefault();
                if (nextMortgageAccount == null)
                {
                    nextMortgageAccount = new NextMortgageAccount();
                    db.NextMortgageAccounts.Add(nextMortgageAccount);
                    db.SaveChanges();
                }
            } 
            return nextMortgageAccount;
        }
    }

    /// <summary>
    /// Represents the InvestmentAccount state of BankAccount.
    /// </summary>
    public class InvestmentAccount : BankAccount
    {
        [Required]
        [Display(Name="Interest\nRate")]
        [DisplayFormat(DataFormatString = "{0:P}")]
        public double InterestRate { get; set; }

        /// <summary>
        /// Sets the next Account number for the Investment account.
        /// </summary>
        public void SetNextAccountNumber()
        {
            AccountNumber = StoredProcedures.NextNumber("NextInvestmentAccounts");
        }
    }

    /// <summary>
    /// Represents the NextInvestmentAccount table. 
    /// </summary>
    public class NextInvestmentAccount
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextInvestmentAccount nextInvestmentAccount;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextInvestmentAccountId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextInvestmentAccount()
        {
            this.NextAvailableNumber = 2000000;
        }

        /// <summary>
        /// Creates an instance of NextInvestmentAccount and makes sure only one is created.
        /// </summary>
        /// <returns></returns>
        public static NextInvestmentAccount GetInstance()
        { 
            if (nextInvestmentAccount == null)
            {
                nextInvestmentAccount = db.NextInvestmentAccounts.SingleOrDefault();
                if (nextInvestmentAccount == null)
                {
                    nextInvestmentAccount = new NextInvestmentAccount();
                    db.NextInvestmentAccounts.Add(nextInvestmentAccount);
                    db.SaveChanges();
                }
            } 
            return nextInvestmentAccount;
        }
    }

    /// <summary>
    /// Represents the ChequingAccount state of BankAccount.
    /// </summary>
    public class ChequingAccount : BankAccount
    {
        [Required]
        [Display(Name="Service\nCharges")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double ChequingServiceCharges { get; set; }

        /// <summary>
        /// Sets the next account number for the ChequingAccount.
        /// </summary>
        public void SetNextAccountNumber()
        {
            AccountNumber = StoredProcedures.NextNumber("NextChequingAccounts");
        }
    }

    /// <summary>
    /// Represents the NextChequingAccount table.
    /// </summary>
    public class NextChequingAccount
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextChequingAccount nextChequingAccount;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextChequingAccountId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextChequingAccount()
        {
            this.NextAvailableNumber = 20000000;
        }

        /// <summary>
        /// Creates an instance of NextChequingAccount and makes sure only one is created.
        /// </summary>
        /// <returns></returns>
        public static NextChequingAccount GetInstance()
        { 
            if (nextChequingAccount == null)
            {
                nextChequingAccount = db.NextChequingAccounts.SingleOrDefault();
                if (nextChequingAccount == null)
                {
                    nextChequingAccount = new NextChequingAccount();
                    db.NextChequingAccounts.Add(nextChequingAccount);
                    db.SaveChanges();
                }
            } 
            return nextChequingAccount;
        }
    }

         /// <summary>
    /// Represents the AccountState table in the database.
    /// </summary>
    public abstract class AccountState
    {

        protected static BankOfBIT_TSContext bankOfBIT = new BankOfBIT_TSContext();

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        [Display(Name="Account\nState\nID")]
        public int AccountStateId { get; set; }

        [Display(Name="Lower\nLimit")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double LowerLimit { get; set; }

        [Display(Name="Upper\nLimit")]
        [DisplayFormat(DataFormatString = "{0:C}")]
        public double UpperLimit { get; set; }

        [Required]
        [Display(Name="Interest\nRate")]
        [DisplayFormat(DataFormatString = "{0:P}")]
        public double Rate { get; set; }

        /// <summary>
        /// Returns the formatted description for the account state.
        /// </summary>
        [Display(Name="Account\nState")]
        public string Description
        {
            get
            {
                string type = GetType().Name;

                if (type.Contains("State"))
                {
                    int length = "State".Length;
                    type = type.Remove(type.IndexOf("State"), length);
                }
                return type;
            }
        }

        /// <summary>
        /// Adjusts the rate depending on the current state.
        /// </summary>
        /// <param name="bankAccount"></param>
        /// <returns></returns>
        public virtual double RateAdjustment(BankAccount bankAccount)
        {
            return this.Rate = RateAdjustment(bankAccount);
            
        }

        /// <summary>
        /// Checks if the state is changed.
        /// </summary>
        /// <param name="bankAccount"></param>
        public virtual void StateChangeCheck(BankAccount bankAccount)
        {
        }       
    }




    /// <summary>
    /// Represents the bronze state of the BankAccount.
    /// </summary>
    public class BronzeState : AccountState
    {
        private static BronzeState bronzeState;

        /// <summary>
        /// Constructs an instance of the BronzeState.
        /// </summary>
        ///        
        private BronzeState()
        {
            this.LowerLimit = 0;
            this.UpperLimit = 5000;
            this.Rate = 0.01;
        }
        

        /// <summary>
        /// Gets the current instance of BronzeState.
        /// </summary>
        /// <returns></returns>
        public static BronzeState GetInstance()
        {
            if (bronzeState == null)
            {
                bronzeState = bankOfBIT.BronzeStates.SingleOrDefault();
                if(bronzeState == null)
                {
                     bronzeState = new BronzeState();
                     bankOfBIT.AccountStates.Add(bronzeState);
                     bankOfBIT.SaveChanges();
                }
            }       
            return bronzeState;
        }

        /// <summary>
        /// Adjusts the rate for BronzeState
        /// </summary>
        /// <param name="bankAccount"></param>
        /// <returns></returns>
        public override double RateAdjustment(BankAccount bankAccount)
        {
            if (bankAccount.Balance <= 0)
            {
                this.Rate = 0.055;
            }
            return this.Rate;
        }

        /// <summary>
        /// Checks the state and changes if needed.
        /// </summary>
        /// <param name="bankAccount"></param>
        public override void StateChangeCheck(BankAccount bankAccount)
        {
            if (bankAccount.Balance > this.UpperLimit)
            {
                bankAccount.AccountStateId = SilverState.GetInstance().AccountStateId;
            }
        }
    }

    /// <summary>
    /// Represents the SilverState of the BankAccount.
    /// </summary>
    public class SilverState : AccountState
    {
        private static SilverState silverState;

        /// <summary>
        /// Constructs an instance of SilverState.
        /// </summary>
        private SilverState()
        {
            this.LowerLimit = 5000;
            this.UpperLimit = 10000;
            this.Rate = 0.0125;
        }

        /// <summary>
        /// Gets the current instance of SilverState.
        /// </summary>
        /// <returns></returns>
        public static SilverState GetInstance()
        {     
            if (silverState == null)
            {
                silverState = bankOfBIT.SilverStates.SingleOrDefault();
                if (silverState == null)
                {
                    silverState = new SilverState();
                    bankOfBIT.AccountStates.Add(silverState);
                    bankOfBIT.SaveChanges();
                }
            }
            return silverState;
        }

        /// <summary>
        /// Adjusts the rate of SilverState.
        /// </summary>
        /// <param name="bankAccount"></param>
        /// <returns></returns>
        public override double RateAdjustment(BankAccount bankAccount)
        {
            return this.Rate;
        }

        /// <summary>
        /// Checks the state and changes if needed.
        /// </summary>
        /// <param name="bankAccount"></param>
        public override void StateChangeCheck(BankAccount bankAccount)
        {
            if (bankAccount.Balance < LowerLimit)
            {
                bankAccount.AccountStateId = BronzeState.GetInstance().AccountStateId;
            }
            else if (bankAccount.Balance > UpperLimit)
            {
                bankAccount.AccountStateId = GoldState.GetInstance().AccountStateId;
            }
        }
    }

    /// <summary>
    /// Represents the GoldState of the BankAccount.
    /// </summary>
    public class GoldState : AccountState
    {
        private static GoldState goldState;

        /// <summary>
        /// Constructs an instance of GoldState.
        /// </summary>
        private GoldState()
        {
            this.LowerLimit = 10000;
            this.UpperLimit = 20000;
            this.Rate = 0.02;

        }

        /// <summary>
        /// Gets the current instance of GoldState.
        /// </summary>
        /// <returns></returns>
        public static GoldState GetInstance()
        {
            if (goldState == null)
            {
                goldState = bankOfBIT.GoldStates.SingleOrDefault();
                if (goldState == null)
                {
                    goldState = new GoldState();
                    bankOfBIT.AccountStates.Add(goldState);
                    bankOfBIT.SaveChanges();
                }
            } 
            return goldState;
        }

        /// <summary>
        /// Adjusts the rate of GoldState.
        /// </summary>
        /// <param name="bankAccount"></param>
        /// <returns></returns>
        public override double RateAdjustment(BankAccount bankAccount)
        {
            if (bankAccount.DateCreated.Year < (DateTime.Now.Year - 10))
            {
                this.Rate = this.Rate + 0.01;
            }
            return this.Rate;
        }

        /// <summary>
        /// Checks the state and changes if needed. 
        /// </summary>
        /// <param name="bankAccount"></param>
        public override void StateChangeCheck(BankAccount bankAccount)
        {
            if (bankAccount.Balance < LowerLimit)
            {
                bankAccount.AccountStateId = SilverState.GetInstance().AccountStateId;
            }
            else if (bankAccount.Balance > UpperLimit)
            {
                bankAccount.AccountStateId = PlatinumState.GetInstance().AccountStateId;
            }
        }
    }

    /// <summary>
    /// Represents the PlatinumState of the BankAccount.
    /// </summary>
    public class PlatinumState : AccountState
    {
        private static PlatinumState platinumState;

        /// <summary>
        /// Constructs an instance of PlatinumState.
        /// </summary>
        private PlatinumState()
        {
            this.LowerLimit = 20000;
            this.UpperLimit = 0;
            this.Rate = 0.0250;
        }

        /// <summary>
        /// Gets the current instance of PlatinumState.
        /// </summary>
        /// <returns></returns>
        public static PlatinumState GetInstance()
        {
            if (platinumState == null)
            {
                platinumState = bankOfBIT.PlatinumStates.SingleOrDefault();
                if (platinumState == null)
                {
                    platinumState = new PlatinumState();
                    bankOfBIT.AccountStates.Add(platinumState);
                    bankOfBIT.SaveChanges();
                }
            } 
            return platinumState;
        }

        /// <summary>
        /// Adjusts the rate of the PlatinumState.
        /// </summary>
        /// <param name="bankAccount"></param>
        /// <returns></returns>
        public override double RateAdjustment(BankAccount bankAccount)
        {
            if (bankAccount.DateCreated.Year < (DateTime.Now.Year - 10))
            {
                this.Rate = this.Rate + 0.01;               
            }

            if (bankAccount.Balance > (this.LowerLimit * 2))
            {
                this.Rate = this.Rate + 0.005;
            }
            return this.Rate;
        }

        /// <summary>
        /// Checks the state and changes if needed.
        /// </summary>
        /// <param name="bankAccount"></param>
        public override void StateChangeCheck(BankAccount bankAccount)
        {
            if (bankAccount.Balance < LowerLimit)
            {
                bankAccount.AccountStateId = GoldState.GetInstance().AccountStateId;
            }
        }
    }

    /// <summary>
    /// Represents the Payee object.
    /// </summary>
    public class Payee
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int PayeeId { get; set; }

        [Display(Name = "Payee")]
        public string Description { get; set; }
    }

    /// <summary>
    /// Represents the Institution object.
    /// </summary>
    public class Institution
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int InstitutionId { get; set; }

        [Display(Name = "Institution\nNumber")]
        public int InstitutionNumber { get; set; }

        [Display(Name = "Institution")]
        public string Description { get; set; }
    }

    /// <summary>
    /// Represents the Transaction object.
    /// </summary>
    public class Transaction
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int TransactionId { get; set; }

        
        [Display(Name = "Transaction\nNumber")]
        public long? TransactionNumber { get; set; }

        [Required]
        [ForeignKey("BankAccount")]
        public int BankAccountId { get; set; }

        [Required]
        [ForeignKey("TransactionType")]
        public int TransactionTypeId { get; set; }

        public double Deposit { get; set; }

        public double Withdrawal { get; set; }

        [Required]
        [Display(Name = "Date\nCreated")]
        public DateTime DateCreated { get; set; }

        // below might get swithed to just notes
        [Display(Name = "Account\nNotes")]
        public string Notes { get; set; }

        public void SetNextTransactionNumber()
        {
            TransactionNumber = StoredProcedures.NextNumber("NextTransactionNumbers");
        }

        public virtual BankAccount BankAccount { get; set; }


        public virtual TransactionType TransactionType { get; set; }
    }

    /// <summary>
    /// Represents the TransactionType Object.
    /// </summary>
    public class TransactionType
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int TransactionTypeId { get; set; }

        [Display(Name = "Tranaction\nType")]
        public string Description { get; set; }

        [Display(Name = "Service\nCharges")]
        public double ServiceCharges { get; set; }
    }

    /// <summary>
    /// Represents the NextTransactionNumber Object.
    /// </summary>
    public class NextTransactionNumber
    {
        protected static BankOfBIT_TSContext db = new BankOfBIT_TSContext();
        private static NextTransactionNumber nextTransactionNumber;

        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int NextTransactionNumberId { get; set; }

        public long NextAvailableNumber { get; set; }

        private NextTransactionNumber()
        {
            this.NextAvailableNumber = 700;
        }

        /// <summary>
        /// returns the instance of NextTransactionNumber
        /// </summary>
        /// <returns></returns>
        public static NextTransactionNumber GetInstance()
        { 
            if (nextTransactionNumber == null)
            {
                nextTransactionNumber = db.NextTransactionNumbers.SingleOrDefault();
                if (nextTransactionNumber == null)
                {
                    nextTransactionNumber = new NextTransactionNumber();
                    db.NextTransactionNumbers.Add(nextTransactionNumber);
                    db.SaveChanges();
                }
            } 
            return nextTransactionNumber;
        }
    }

    /// <summary>
    /// Represents the RFIDTag Object.
    /// </summary>
    public class RFIDTag
    {
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.Identity)]
        public int RFIDTagId { get; set; }

        public long CardNumber { get; set; }

        [Required]
        [ForeignKey("Client")]
        public int ClientId { get; set; }

        // navigation 
        public virtual Client Client { get; set; }
    }

    /// <summary>
    /// StoredProcedures class. Holds the connection to the database and fills variables needed to run the scripts.
    /// </summary>
    public static class StoredProcedures
    {
        /// <summary>
        /// Gets the next number for the provided table.
        /// </summary>
        /// <param name="tableName"></param>
        /// <returns></returns>
        public static long? NextNumber(string tableName)
        {
            // gets db connection path
            SqlConnection connection = new SqlConnection("Data Source=localhost;Initial Catalog=BankOfBIT_TSContext;Integrated Security=True");

            long? returnValue = 0;

            // setting the variables for input and output (like what we did we testing. Except automatic)
            // Also sets the script to the commandType property 
            SqlCommand storedProcedure = new SqlCommand("next_number", connection);
            storedProcedure.CommandType = CommandType.StoredProcedure;
            storedProcedure.Parameters.AddWithValue("@TableName", tableName);

            SqlParameter outputParameter = new SqlParameter("@NewVal", SqlDbType.BigInt)
            {
                Direction = ParameterDirection.Output
            };

            // adding to the parameters 
            storedProcedure.Parameters.Add(outputParameter);

            // open connection
            connection.Open();

            // execture the query
            storedProcedure.ExecuteNonQuery();

            // close connection
            connection.Close();

            // get value to return 
            returnValue = (long?)outputParameter.Value;
            return returnValue;
        }
    }
}