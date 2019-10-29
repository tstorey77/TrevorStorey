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
    public class ChequingAccountController : Controller
    {
        private BankOfBIT_TSContext db = new BankOfBIT_TSContext();

        //
        // GET: /ChequingAccount/

        public ActionResult Index()
        {
            var bankaccounts = db.ChequingAccounts.Include(c => c.Client).Include(c => c.AccountState);
            return View(bankaccounts.ToList());
        }

        //
        // GET: /ChequingAccount/Details/5

        public ActionResult Details(int id = 0)
        {
            ChequingAccount chequingaccount = (ChequingAccount)db.BankAccounts.Find(id);
            if (chequingaccount == null)
            {
                return HttpNotFound();
            }
            return View(chequingaccount);
        }

        //
        // GET: /ChequingAccount/Create

        public ActionResult Create()
        {
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName");
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description");
            return View();
        }

        //
        // POST: /ChequingAccount/Create

        [HttpPost]
        public ActionResult Create(ChequingAccount chequingaccount)
        {
            chequingaccount.SetNextAccountNumber();

            if (ModelState.IsValid)
            {
                db.BankAccounts.Add(chequingaccount);
                db.SaveChanges();
                chequingaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", chequingaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", chequingaccount.AccountStateId);
            return View(chequingaccount);
        }

        //
        // GET: /ChequingAccount/Edit/5

        public ActionResult Edit(int id = 0)
        {
            ChequingAccount chequingaccount = (ChequingAccount)db.BankAccounts.Find(id);
            if (chequingaccount == null)
            {
                return HttpNotFound();
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", chequingaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", chequingaccount.AccountStateId);
            return View(chequingaccount);
        }

        //
        // POST: /ChequingAccount/Edit/5

        [HttpPost]
        public ActionResult Edit(ChequingAccount chequingaccount)
        {
            if (ModelState.IsValid)
            {
                db.Entry(chequingaccount).State = EntityState.Modified;
                db.SaveChanges();
                chequingaccount.ChangeState();
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ClientId = new SelectList(db.Clients, "ClientId", "FullName", chequingaccount.ClientId);
            ViewBag.AccountStateId = new SelectList(db.AccountStates, "AccountStateId", "Description", chequingaccount.AccountStateId);
            return View(chequingaccount);
        }

        //
        // GET: /ChequingAccount/Delete/5

        public ActionResult Delete(int id = 0)
        {
            ChequingAccount chequingaccount = (ChequingAccount)db.BankAccounts.Find(id);
            if (chequingaccount == null)
            {
                return HttpNotFound();
            }
            return View(chequingaccount);
        }

        //
        // POST: /ChequingAccount/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(int id)
        {
            ChequingAccount chequingaccount = (ChequingAccount)db.BankAccounts.Find(id);
            db.BankAccounts.Remove(chequingaccount);
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