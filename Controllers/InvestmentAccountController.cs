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
    public class InvestmentAccountController : Controller
    {
        private BankOfBIT_TSContext db = new BankOfBIT_TSContext();

        //
        // GET: /InvestmentAccount/

        public ActionResult Index()
        {
            var bankaccounts = db.InvestmentAccounts.Include(i => i.Client).Include(i => i.AccountState);
            return View(bankaccounts.ToList());
        }

        //
        // GET: /InvestmentAccount/Details/5

        public ActionResult Details(int id = 0)
        {
            InvestmentAccount investmentaccount = (InvestmentAccount)db.BankAccounts.Find(id);
            if (investmentaccount == null)
            {
                return HttpNotFound();
            }
            return View(investmentaccount);
        }

        //
        // GET: /InvestmentAccount/Create

        public ActionResult Create()
        {
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName");
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description");
            return View();
        }

        //
        // POST: /InvestmentAccount/Create

        [HttpPost]
        public ActionResult Create(InvestmentAccount investmentaccount)
        {
            investmentaccount.SetNextAccountNumber();
            if (ModelState.IsValid)
            {
                db.BankAccounts.Add(investmentaccount);
                db.SaveChanges();
                investmentaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", investmentaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", investmentaccount.AccountStateId);
            return View(investmentaccount);
        }

        //
        // GET: /InvestmentAccount/Edit/5

        public ActionResult Edit(int id = 0)
        {
            InvestmentAccount investmentaccount = (InvestmentAccount)db.BankAccounts.Find(id);
            if (investmentaccount == null)
            {
                return HttpNotFound();
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", investmentaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", investmentaccount.AccountStateId);
            return View(investmentaccount);
        }

        //
        // POST: /InvestmentAccount/Edit/5

        [HttpPost]
        public ActionResult Edit(InvestmentAccount investmentaccount)
        {
            if (ModelState.IsValid)
            {
                db.Entry(investmentaccount).State = EntityState.Modified;
                db.SaveChanges();
                investmentaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", investmentaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", investmentaccount.AccountStateId);
            return View(investmentaccount);
        }

        //
        // GET: /InvestmentAccount/Delete/5

        public ActionResult Delete(int id = 0)
        {
            InvestmentAccount investmentaccount = (InvestmentAccount)db.BankAccounts.Find(id);
            if (investmentaccount == null)
            {
                return HttpNotFound();
            }
            return View(investmentaccount);
        }

        //
        // POST: /InvestmentAccount/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            InvestmentAccount investmentaccount = (InvestmentAccount)db.BankAccounts.Find(id);
            db.BankAccounts.Remove(investmentaccount);
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