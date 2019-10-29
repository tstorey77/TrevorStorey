using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BankOfBIT_TS.Models;

namespace BankOfBIT_TS.Controllers
{
    public class MortgageAccountController : Controller
    {
        private BankOfBIT_TSContext db = new BankOfBIT_TSContext();

        //
        // GET: /MortgageAccount/

        public ActionResult Index()
        {
            var bankaccounts = db.MortgageAccounts.Include(m => m.Client).Include(m => m.AccountState);
            return View(bankaccounts.ToList());
        }

        //
        // GET: /MortgageAccount/Details/5

        public ActionResult Details(int id = 0)
        {
            MortgageAccount mortgageaccount = (MortgageAccount)db.BankAccounts.Find(id);
            if (mortgageaccount == null)
            {
                return HttpNotFound();
            }
            return View(mortgageaccount);
        }

        //
        // GET: /MortgageAccount/Create

        public ActionResult Create()
        {
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName");
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description");
            return View();
        }

        //
        // POST: /MortgageAccount/Create

        [HttpPost]
        public ActionResult Create(MortgageAccount mortgageaccount)
        {
            mortgageaccount.SetNextAccountNumber();
            if (ModelState.IsValid)
            {
                db.BankAccounts.Add(mortgageaccount);
                db.SaveChanges();
                mortgageaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", mortgageaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", mortgageaccount.AccountStateId);
            return View(mortgageaccount);
        }

        //
        // GET: /MortgageAccount/Edit/5

        public ActionResult Edit(int id = 0)
        {
            MortgageAccount mortgageaccount = (MortgageAccount)db.BankAccounts.Find(id);
            if (mortgageaccount == null)
            {
                return HttpNotFound();
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", mortgageaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", mortgageaccount.AccountStateId);
            return View(mortgageaccount);
        }

        //
        // POST: /MortgageAccount/Edit/5

        [HttpPost]
        public ActionResult Edit(MortgageAccount mortgageaccount)
        {
            if (ModelState.IsValid)
            {
                db.Entry(mortgageaccount).State = EntityState.Modified;
                db.SaveChanges();
                mortgageaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", mortgageaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", mortgageaccount.AccountStateId);
            return View(mortgageaccount);
        }

        //
        // GET: /MortgageAccount/Delete/5

        public ActionResult Delete(int id = 0)
        {
            MortgageAccount mortgageaccount = (MortgageAccount)db.BankAccounts.Find(id);
            if (mortgageaccount == null)
            {
                return HttpNotFound();
            }
            return View(mortgageaccount);
        }

        //
        // POST: /MortgageAccount/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            MortgageAccount mortgageaccount = (MortgageAccount)db.BankAccounts.Find(id);
            db.BankAccounts.Remove(mortgageaccount);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            db.Dispose();
            base.Dispose(disposing);
        }
    }
}